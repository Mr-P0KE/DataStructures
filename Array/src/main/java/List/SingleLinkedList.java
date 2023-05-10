package List;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @Author: Mr_Poke
 * @Date: 2023/4/28 23:59
 * @Description: 单链表，不带哨兵
 */
public class SingleLinkedList implements Iterable<Integer>{
    private static class Node{
        public int val;
        public Node next;
        public Node (int val){
            this.val = val;
        }
        public Node (int val,Node next){
            this.val = val;

            this.next = next;
        }

    }

    private Node head;
    /**
    * @Author Mr_Poke
    * @Date 13:21 2023/4/29
    * @Description  头插法
    * @Param  * @param node
    * @Return void
    */
    public void addFirst(int val){
        //head = new Node(val,null);
         head = new Node(val,head);
    }
    /**
    * @Author Mr_Poke
    * @Date 16:34 2023/5/4
    * @Description  尾插法
    * @Param  * @param val
    * @Return void
    */
    public void addLast(int val){
        Node temp = findLast();
        if(temp == null){
            addFirst(val);
            return;
        }
            temp.next = new Node(val,null);
    }
    /**
    * @Author Mr_Poke
    * @Date 16:45 2023/5/4
    * @Description  中间插入
    * @Param  * @param val
    * @Return void
    */
    public void insert(int index,int val){
        Node temp = findNode(index -1);
        if(temp == null)
            throw new IllegalArgumentException(String.format("index[%d]不合法",index));
        temp.next = new Node(val,temp.next);
    }
    /**
    * @Author Mr_Poke
    * @Date 16:31 2023/5/4
    * @Description  查找最后的元素
    * @Param  * @param val
    * @Return List.SingleLinkedList.Node
    */
    private Node findLast(){
        Node temp = head;
        if(temp == null)
            return null;
        while (temp.next != null) temp = temp.next;
        return temp;
    }
    public void list(Consumer<Integer> consumer){
            Node temp = head.next;
            while(temp != null){
               consumer.accept(temp.val);
                temp = temp.next;
            }

    }
    /**
    * @Author Mr_Poke
    * @Date 16:41 2023/5/4
    * @Description  查找索引
    * @Param  * @param index
    * @Return List.SingleLinkedList.Node
    */
    private Node findNode(int index){
        int i = 0;
        for(Node n = head;n!=null;n = n.next,i++){
            if(i == index)
                return n;
        }
        return null;
    }
    public int get(int index)  {
        Node temp = findNode(index);
        if(temp == null)
            throw new IllegalArgumentException(String.format("index[%d]不合法",index));
        return temp.val;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new IntegerIterator();
    }
    private class IntegerIterator implements Iterator<Integer> {
        Node temp = head;

        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public Integer next() {
            int v = temp.val;
            temp = temp.next;
            return v;
        }
    }

    public void removeFirst(){
        if(head == null)
            return;
        head = head.next;
    }
    public void remove(int index){
        if(index == 0){
            removeFirst();
            return;
        }
        Node n = findNode(index-1);
        if (n == null)
            throw new IllegalArgumentException(String.format("index[%d]不合法",index));
        if(n.next == null)
            throw new IllegalArgumentException(String.format("index[%d]不合法",index));
        n.next = n.next.next;
    }

    /**
    * @Author Mr_Poke
    * @Date 15:25 2023/5/5
    * @Description  递归遍历
    * @Param  * @param
    * @Return void
    */
    public void loop(Consumer<Integer> before,
                     Consumer<Integer> after){
        Node temp = head;
        recursion(temp,before,after);
    }
    /**
    * @Author Mr_Poke
    * @Date  2023/5/5
    * @Description  递归实现方法
    * @Param  * @param head
    * @Return void
    */
    private void recursion(Node head,Consumer<Integer> before,
                           Consumer<Integer> after){
        if(head == null)
            return ;
        before.accept(head.val);
        recursion(head.next,before,after);
        after.accept(head.val);
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        for (int i = 0; i < 3; i++) {
            list.addLast(i);
        }
        list.loop(val->{
            System.out.println("before "+val);
        },val ->{
            System.out.println("after " +val);
        });
    }
}
