package Heap;

import java.util.Arrays;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/7 17:04
 * @Description: 大顶堆
 */
public class MaxHeap implements Head{
    private int[] array;
    private int size;



    public MaxHeap(int capacity) {
        this.array = new int[capacity];
    }
    public MaxHeap(int[] array){
        this.array = array;
        this.size = array.length;
        buildHead();
    }
    /**
    * @Author Mr_Poke
    * @Date 18:50 2023/5/7
    * @Description  建堆算法
    * @Param  * @param
    * @Return void
    */
    private void  buildHead(){
        for (int i = (size -1) / 2;i>=0;--i){
            down(i);
        }
    }
    @Override
    public void heapify() {

    }
    @Override
    public int poll() {
       if(isEmpty())
           return -1;
       int i = array[0];
       size--;
       swap(0,size);
       down(0);
        return i;
    }

    /**
    * @Author Mr_Poke
    * @Date 21:17 2023/5/7
    * @Description  头部加入
    * @Param  * @param index
    * @Return int
    */
    @Override
    public int poll(int index) {
        if(index > size || index < 0)
            throw new IllegalArgumentException("参数非法");
        int deleted = array[index];
        swap(index,size-1);
        size--;
        down(0);
        return deleted;
    }


    @Override
    public int peek() {
        if(isEmpty())
            return -1;
        return array[0];
    }

    @Override
    public void replace(int val) {
        array[0] = val;
       down(0);
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
    * @Author Mr_Poke
    * @Date 21:17 2023/5/7
    * @Description  尾部加入
    * @Param  * @param val
    * @Return boolean
    */
    @Override
    public boolean offer(int val) {
        if(isFull())
            return false;
        array[size] = val;
        up(val);
        size++;
        return true;
    }
    private void up(int val){
        int i = size;
        int parent =  (i -1) / 2;
        while (i > 0 && val > array[parent]){
            array[i] = array[parent];
            i = parent;
            parent = (i -1) / 2;
        }
        array[i] = val;
    }

    private void down(int parent){
        int l = parent * 2 +1;
        int r = l + 1;
        int max = parent;
        if( l < size && array[l] > array[max]){
            max = l;
        }
        if( r < size && array[r] > array[max]){
            max = r;
        }
        if(max != parent){
            swap(max,parent);
            down(max);
        }
    }

    private void swap(int i,int j){
        int temp = array[i];
        array[i]  = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        MaxHeap heap = new MaxHeap(10);
        for (int i = 0; i < 7; i++) {
            heap.offer(i);
        }
        System.out.println(Arrays.toString(heap.array));
        for (int i = 0; i < 8; i++) {
            System.out.println(heap.poll());
        }
    }
}
