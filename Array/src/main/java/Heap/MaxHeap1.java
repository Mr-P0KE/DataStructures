package Heap;

import java.util.Arrays;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/7 21:42
 * @Description:
 */
public class MaxHeap1 implements Head{
    private int[] array;
    private int size;

    public MaxHeap1(int capacity) {
        this.array = new int[capacity];
    }

    public MaxHeap1(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    @Override
    public void heapify() {
        for(int i = (size - 1) / 2 ;i >= 0;i--){
            down(i);
        }
    }
    public void down(int index){
        int l = index * 2 +1;
        int r = l+1;
        int max = index;
        if(l < size && array[l] > array[max])
            max = l;
        if(r < size && array[r] > array[max])
            max = r;
        if(array[max] != array[index]){
            swap(max,index);
            down(max);
        }
    }

    private void swap(int max, int index) {
        int temp = array[max];
        array[max] = array[index];
        array[index] = temp;
    }

    @Override
    public int poll() {
        return 0;
    }

    @Override
    public int poll(int index) {
        return 0;
    }

    @Override
    public int peek() {
        return 0;
    }

    @Override
    public boolean offer(int val) {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void replace(int val) {

    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        MaxHeap1 heap = new MaxHeap1(a);

        System.out.println(Arrays.toString(heap.array));
        for (int i = 0; i < 8; i++) {
            System.out.println(heap.poll());
        }
    }
}
