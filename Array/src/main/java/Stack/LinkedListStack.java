package Stack;

import java.util.Iterator;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/6 15:16
 * @Description: ¡¥±Ì µœ÷’ª
 */
public class LinkedListStack<E> implements Stack<E>,Iterable<E>{

    private static class Node<E>{
        private E val;
        private Node<E> next;

        public Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }
    private final int capacity;
    private int size;
    private Node<E> head = new Node<E>(null,null);

    public LinkedListStack() {
        this.capacity = Integer.MAX_VALUE;
    }

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean push(E value) {
        if(isFull())
            return false;
        head.next = new Node<>(value, head.next);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if(isEmpty())
            return null;
        Node<E> node = head.next;
        head.next = node.next;
        size--;
        return node.val;
    }

    @Override
    public E peek()
    {
        if(isEmpty())
            return null;
        return head.next.val;
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
                return node != null;
            }

            @Override
            public E next() {
                E temp = node.val;
                node = node.next;
                return temp;
            }
        };
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> es = new LinkedListStack<Integer>(5);
        for (int i = 0; i < 5; i++) {
            es.push(i);
        }
        es.pop();
        for(int  val : es){
            System.out.println(val);
        }
    }
}
