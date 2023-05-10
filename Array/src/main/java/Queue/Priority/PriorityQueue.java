package Queue.Priority;


import Queue.Queue;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/7 11:55
 * @Description: 优先队列
 */
public class PriorityQueue<E extends Priority> implements Queue<E> {
    private Priority[] priorities;
    private int size;

    public PriorityQueue(int capacity) {
        priorities = new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {
        if(isFull())
            return false;
        priorities[size] = value;
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
    private int findMax(){
        int max = 0;
        for(int i = 1;i<size;i++){
            max = priorities[max].priority() > priorities[i].priority() ? max : i;
        }
        return max;
    }
    @Override
    public E poll() {
        if(isEmpty())
            return null;
        int max = findMax();
        E e = (E) priorities[max];
        remove(max);
        return e;
    }
    private void remove(int index){
        if (index < size - 1)
            System.arraycopy(priorities,index+1,priorities,index,size-index+1);
        priorities[--size] = null;

    }
    @Override
    public E peek() {
        if(isEmpty())
            return null;
        return (E) priorities[findMax()];
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
        PriorityQueue<Entry<String>> queue = new PriorityQueue<>(3);
        queue.offer(new Entry<String>("task1",1));
        queue.offer(new Entry<String>("task2",2));
        queue.offer(new Entry<String>("task3",3));
        queue.offer(new Entry<String>("task4",4));
//        System.out.println(queue.peek());

        Entry<String> poll = queue.poll();
        queue.offer(new Entry<String>("task4",4));
        System.out.println(poll);
        System.out.println(queue.peek());
//        System.out.println(queue.peek());
    }
}
