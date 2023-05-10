package Dueue;

import java.util.Iterator;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/6 18:08
 * @Description: 双向环形链表实现
 */
public class LinkedListNodeDeque<E> implements Deque<E>,Iterable<E>{
    private static class Node<E>{
        private E val;
        private Node<E> next;
        private Node<E> prev;
        public Node(E val, Node<E> prev,Node<E> next) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> head = new Node<>(null,null,null);
    private int capacity = Integer.MAX_VALUE;
    private int size;

    {
        this.head.prev = head;
        this.head.next = head;
    }
    public LinkedListNodeDeque() {
    }

    public LinkedListNodeDeque(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean offerFirst(E e) {
        if(isFull())
            return false;
        Node<E> temp = head.next;
        Node<E> node  = new Node<>(e,head,temp);
        head.next = node;
        temp.prev = node;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if(isFull())
            return false;
        Node<E> temp = head.prev;
        Node<E> node  = new Node<>(e,temp,head);
        head.prev = node;
        temp.next = node;
        size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if(isEmpty())
            return null;
        Node<E> node = head.next;
        head.next = node.next;
        node.next.prev = head;
        size--;
        return node.val;
    }

    @Override
    public E pollLast() {
        if(isEmpty())
            return null;
        Node<E> node = head.prev;
        head.prev = node.prev;
        node.prev.next = head;
        size--;
        return node.val;
    }

    @Override
    public E peekFirst() {
        if(isFull())
            return null;
        return head.next.val;
    }

    @Override
    public E peekLast() {
        if(isFull())
            return null;
        return head.prev.val;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> node = head.next;
            @Override
            public boolean hasNext() {
                return node != head;
            }

            @Override
            public E next() {
                E val = node.val;
                node = node.next;
                return val;
            }
        };
    }

    public static void main(String[] args) {
        LinkedListNodeDeque<Integer> list = new LinkedListNodeDeque<>(3);
        for (int i = 0; i < 5; i++) {
            list.offerFirst(i);
        }
        for (int i = 5; i < 10; i++) {
            list.offerLast(i);
        }

        for(int val : list){
            System.out.println(val);
        }
    }
}
