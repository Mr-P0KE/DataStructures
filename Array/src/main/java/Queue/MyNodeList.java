package Queue;

import java.util.Iterator;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/6 13: 38
 * @Description: 单向环形带哨兵链表实现队列
 */
public class MyNodeList<E> implements Queue<E>,Iterable<E>{

    private static class Node<E>{
        private E val;
        private Node<E> next;
        public Node(E val) {
            this.val = val;
        }
        public Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node<E> head = new Node<>(null,null);
    /**
     * TODO 属性描述 尾节点
     */
    private Node<E> tail  = head;
    private int size;
    private int capacity = Integer.MAX_VALUE;
    {
        this.tail.next = head;
    }
    public MyNodeList() {

    }
    public MyNodeList(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean offer(E value) {
        if(!isFull()){
            Node<E> node = new Node<>(value, head);
            tail.next = node;
            tail = node;
            size++;
            return true;
        }else
            return false;
    }

    @Override
    public E poll() {
        if(isEmpty())
            return null;
        Node<E> node = head.next;
        head.next = node.next;
        if(node == tail)
            tail = head;
        size--;
        return node.val;
    }

    @Override
    public E peek() {
        if(!isEmpty())
            return tail.val;
        return null;
    }

    @Override
    public boolean isEmpty() {
        return tail == head;
    }

    @Override
    public boolean isFull() {
        return size >= capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> n = head.next;
            @Override
            public boolean hasNext() {
                return n != head;
            }

            @Override
            public E next() {
                E val =  n.val;
                n = n.next;
                return val;
            }
        };
    }


}
