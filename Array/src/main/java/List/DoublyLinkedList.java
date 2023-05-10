package List;

import java.nio.file.NotDirectoryException;
import java.util.Iterator;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/4 17:47
 * @Description:  双向链表（哨兵）
 */
public class DoublyLinkedList implements Iterable<Integer>{


    static class Node{
        public int val;
        public Node prev;
        public Node next;
        public Node(int val){
            this.val = val;
        }
        public Node(int val,Node prev,Node next){
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    private final Node head;
    private Node tail;
    public DoublyLinkedList() {
        head = new Node(-1,null,tail);
        tail = new Node(-1,head,null);
    }
    private Node findNode(int index){
        if(index < 0)
            throw illegalIndex(index);
        int i = -1;
        for (Node temp = head; temp != tail; temp = temp.next,i++) {
            if(index == i)
                return temp;
        }
        return  null;
    }
    public void addFirst(int val){
        Node pre = head.next;
        Node temp = new Node(val,head,pre);
        head.next = temp;
        pre.prev = temp;

    }
    public void removeFirst(){
        remove(0);
    }
    public void addLast(int val){
        Node pre = tail.prev;
        Node temp = new Node(val,pre,tail);
        pre.next = temp;
        tail.prev =  temp;
    }
    public void removeLast(){
        Node pre = tail.prev;
        if(pre == head)
            throw illegalIndex(0);
        Node temp = pre.prev;
        temp.next = tail;
        tail.prev = temp;
    }
    public void insert(int index,int val){
        Node temp = findNode(index-1);
        if(temp == null )
            throw illegalIndex(index);

        Node next = temp.next;
        Node n = new Node(val,temp,next);
        temp.next = n;
        next.prev = n;
    }
    public void remove(int index){
        Node pre = findNode(index-1);
        if(pre == null || pre == tail || pre.next == tail)
            throw illegalIndex(index);
        Node temp = pre.next;
        Node next = temp.next;
        pre.next = next;
        next.prev = pre;
    }
    private IllegalArgumentException illegalIndex(int index){
        return new IllegalArgumentException(String.format("index[%d]不合法",index));
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node n = head.next;
            @Override
            public boolean hasNext() {
                return n != tail;
            }

            @Override
            public Integer next() {
                int val = n.val;
                n = n.next;
                return val;
            }
        };
    }
}
