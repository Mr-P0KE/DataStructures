package List;

import java.util.Iterator;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/4 22:37
 * @Description: 双向环形链表（哨兵）
 */
public class DoublyLinkedListSentinel implements Iterable<Integer>{
    private static class Node{
        private int val;
        private Node prev;
        private Node next;
        public Node(int val,Node prev,Node next){
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    private final Node head = new Node(-1,null,null);

    public DoublyLinkedListSentinel() {
        this.head.prev = head;
        this.head.next = head;
    }


    private Node findNode(int index){
        int i = -1;
        for(Node n = head.next;n != head;n = n.next,i++){
            if(i == index )
                return n;
        }
        return null;
    }
    private Node findByValue(int val){
        Node node = head.next;
        while (node != head){
           if(node.val == val)
               return node;
           node = node.next;
        }
        return null;
    }
    public void addFirst(int val){
        Node next = head.next;
        Node temp = new Node(val,head,next);
        head.next = temp;
        next.prev = temp;
    }

    public void addLast(int val){
        Node temp = head.prev;
        Node node = new Node(val,temp,head);
        head.prev = node;
        temp.next = node;
    }
    public void removeFirst(){
        Node node = head.next;
        if(node == head)
            throw new IllegalArgumentException("非法");
        Node pre = node.next;
        pre.prev = head;
        head.next  =pre;

    }
    public void removeLast(){
        Node node = head.prev;
        if(node == head)
            throw new IllegalArgumentException("非法");
        node.prev.next = head;
        head.prev = node.prev;
    }
    public void insert(int index,int val){

    }
    public void remove(int val){
        Node node = findByValue(val);
        if(node == null)
            throw new RuntimeException("List中不存在"+val+"值");
        node.prev.next = node.next;
        node.next.prev = node.prev;
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
                return n != head;
            }

            @Override
            public Integer next() {
                int val = n.val;
                n = n.next;
                return val;
            }
        };
    }

    public static void main(String[] args) {
        DoublyLinkedListSentinel integers = new DoublyLinkedListSentinel();
        for (int i = 0; i < 10; i++) {
            integers.addLast(i);
        }

        integers.remove(12);
        for(int val : integers){
            System.out.println(val);
        }

        //System.out.println(integers.head.next.val);
    }
}
