package Queue.Priority;

import Queue.Queue;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/7 13:01
 * @Description:
 */
public class PriorityQueue2<E extends Priority> implements Queue<E> {
    private Priority[] priorities;
    private int size;

    public PriorityQueue2(int capacity) {
        priorities = new Priority[capacity];
    }

    private void  add(E value){
        int i = size-1;
        while (i >= 0 && value.priority() < priorities[i].priority()){
            priorities[i + 1] = priorities[i];
            i--;
        }
        priorities[i+1] = value;
    }
    @Override
    public boolean offer(E value) {
        if(isFull())
            return false;
        add(value);
        size++;
        return true;
    }

    /**
     * @Author Mr_Poke
     * @Date 12:03 2023/5/7
     * @Description 返回优先级最高的索引值
     * @Param  * @param
     * @Return int
     */
    @Override
    public E poll() {
        if(isEmpty())
            return null;
        E priority = (E)priorities[size-1];
        //GC
        priorities[--size] = null;
        return  priority;
    }

    @Override
    public E peek() {
        if(isEmpty())
            return null;
        return (E) priorities[size -1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == priorities.length;
    }

    public static void main(String[] args) {
        PriorityQueue2<Entry<String>> queue = new PriorityQueue2<>(3);
        queue.offer(new Entry<>("task1", 1));
        queue.offer(new Entry<>("task2", 2));
        queue.offer(new Entry<>("task3", 3));
        queue.offer(new Entry<>("task4", 4));
        System.out.println("peek : "+queue.peek());
        Entry<String> poll = queue.poll();
        System.out.println(poll);
        System.out.println("peek : "+queue.peek());
    }
}

