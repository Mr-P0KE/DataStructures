package Queue.Priority;

import Queue.Queue;

import java.util.Iterator;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/7 14:23
 * @Description:
 */
public class PriorityQueue3<E extends Priority> implements Queue<E>,Iterable<E> {
    private Priority[] array;
    private int size;

    public PriorityQueue3(int capacity) {
        this.array =  new Priority[capacity];
    }

    private void add(E val){
        int child = size++;
        int parent = (child - 1) / 2;
        while (child > 0 && val.priority() > array[parent].priority()){
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = val;
    }
    @Override
    public boolean offer(E value) {
        if(isFull())
            return false;
        add(value);
        return true;
    }
    /**
    * @Author Mr_Poke
    * @Date 15:16 2023/5/7
    * @Description  ΩªªªŒª÷√
    * @Param  * @param i
     * @param j
    * @Return void
    */
    private void  swap(int i,int j){
        Priority p = array[i];
        array[i] = array[j];
        array[j] = p;
    }



    private void balance(int parent){
        int l =  parent * 2 + 1;
        int r =  l + 1;
        int max = parent;
        if( l < size && array[max].priority() < array[l].priority()){
           max = l;
        }
        if (r < size && array[max].priority() < array[r].priority()){
            max = r;
        }
        if(max != parent){
            swap(max,parent);
            balance(max);
        }

    }
    @Override
    public E poll() {
        if (isEmpty())
            return null;
        swap(0,size-1);
        size--;
        E e = (E) array[size];
        array[size] = null;
        balance(0);
        return e;
    }

    @Override
    public E peek() {
        if(isEmpty())
            return null;
        return (E) array[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i != size;
            }

            @Override
            public E next() {
                E e = (E) array[i];
                i++;
                return e;
            }
        };
    }
    public static void main(String[] args) {
        PriorityQueue3<Entry> queue3 = new PriorityQueue3<>(3);
        queue3.offer(new Entry<String>("task1",1));
        queue3.offer(new Entry<String>("task2",10));
        queue3.offer(new Entry<String>("task3",4));

        for(Entry e : queue3){
            System.out.println(e.toString());
        }
        System.out.println("========");
        System.out.println(queue3.poll());
        queue3.offer(new Entry<String>("task4",7));
        System.out.println(queue3.poll());
    }
}
