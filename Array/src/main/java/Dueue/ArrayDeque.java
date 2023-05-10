package Dueue;

import java.util.Iterator;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/6 18:07
 * @Description:
 */
public class ArrayDeque<E> implements Deque<E>,Iterable<E>{
    private E[] array ;
    private int l;
    private int r;
    private int capacity = Integer.MAX_VALUE;


    public ArrayDeque() {
    }
    public ArrayDeque(int capacity) {
        this.array = (E[]) new Object[capacity+1];
        this.capacity = capacity+1;
    }
    static int inc(int i,int length){
        if(i+1 >= length)
            return i = 0;
        return ++i;
    }
    static int dec(int i,int length){
        if(i-1 < 0)
            return i = length-1;
        return --i;
    }
    @Override
    public boolean offerFirst(E e) {
        if(isFull())
            return false;
        l = dec(l,capacity);
        array[l] = e;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if(isFull())
            return false;
        array[r] = e;
        r = inc(r,capacity);
        return true;
    }

    @Override
    public E pollFirst() {
        if(isEmpty())
            return null;
        E e = array[l];
        //±ãÓÚGC
        array[l] =null;
        l = inc(l,capacity);
        return e;
    }

    @Override
    public E pollLast() {
        if(isEmpty())
            return null;
        E e = array[r];
        //±ãÓÚGC
        array[r] =null;
        r = dec(r,capacity);
        return e;
    }

    @Override
    public E peekFirst() {
        if (isFull())
            return null;
        return array[l];
    }

    @Override
    public E peekLast() {
        if(isFull())
            return null;
        return array[dec(r,capacity)];
    }

    @Override
    public boolean isEmpty() {
        return l == r;
    }

    @Override
    public boolean isFull() {
        return (r + 1) % capacity == l;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int temp  = l;
            @Override
            public boolean hasNext() {
                return temp != r;
            }

            @Override
            public E next() {
                E e = array[temp];
                temp = inc(temp,capacity);
                return e;
            }
        };
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>(3);
        deque.offerFirst(1);
        deque.offerLast(3);
        deque.offerLast(2);
        for(int i : deque){
            System.out.println(i);
        }
    }
}
