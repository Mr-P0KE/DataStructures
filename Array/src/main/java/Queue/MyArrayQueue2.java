package Queue;

import java.util.Iterator;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/6 15:16
 * @Description:
 */
public class MyArrayQueue2<E> implements Queue<E>,Iterable<E>{
    private final E[] array;
    private int head;
    private int tail;

    public MyArrayQueue2(int capacity) {
        array = (E[]) new Object[capacity];
        //capacity 是否为2的n次方, eg:4 & 3 = 0
        if((capacity & capacity) == 0){

        }else{ //不是2的n次方，进行处理，eg: 30 补齐为32，n = 5,计算 log2(30)+1

//            //求n为多少，具体对数看换底公式: log2(n) = log10(n)/log10(2)
//            int temp = (int) (Math.log(capacity) /Math.log(2)) +1;
        }
    }

    @Override
    public boolean offer(E value) {
        if(isFull())
            return false;
        // tail % array.length的位运算
        array[ tail & (array.length-1)] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty())
            return null;
        E val =array[ head & (array.length)];
        head++;
        return val;
    }

    @Override
    public E peek() {
        if(isEmpty())
            return null;
        return array[ head & (array.length)];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return tail - head == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int i = head;
            @Override
            public boolean hasNext() {
                return i != tail;
            }

            @Override
            public E next() {
                E e = array[i & (array.length -1)];
                i++;
                return e;
            }
        };
    }
}
