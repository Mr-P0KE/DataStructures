package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.stream.IntStream;
/**
 * @Author: Mr_Poke
 * @Date: 2023/4/28 18:16
 * @Description:  动态数组的简单实现
 */
public class MyArrayList implements Iterable<Integer>{
    private int size = 0;
    private int capacity = 8;
 
    private int[] array = {};

    public MyArrayList(int initCapacity){
        this.array = new int[initCapacity];
    }
    public MyArrayList(){

    }
    public void add(int element){
        if(this.size() == 0){
            this.array = new int[capacity];
        }else if(this.size == capacity  ){
            capacity += capacity>>1;
            this.array = Arrays.copyOf(array, capacity);

        }
        array[size] = element;
        size++;
    }
    public int  get(int index){
        if(size == 0)
            throw  new RuntimeException("集合没有元素");

        if(index < this.array.length && index >= 0){
            return array[index];
        } else
            throw new ArrayIndexOutOfBoundsException("数组下标越界啦");
    }
    public int remove(int index){
        int removed = array[index];
        if(size == 0)
            throw new RuntimeException("集合为空");
        System.arraycopy(array,index+1,array,index,size-index-1);
        size--;
        return removed;
    }
    public void foreach(Consumer<Integer> consumer){
        for (int i = 0; i < this.size; i++) {
            consumer.accept(i);
        }
    }

    public int size(){
        return this.size;
    }


    /**
    * @Author Mr_Poke
    * @Date 17:26 2023/5/3
    * @Description  迭代器
    * @Param  * @param
    * @Return java.util.Iterator<java.lang.Integer>
    */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index = 0;
            @Override
            public boolean hasNext() {
               return index < size;
            }

            @Override
            public Integer next() {
                return array[index++];
            }
        };
    }
    public IntStream stream(){
        return IntStream.of(Arrays.copyOf(array,size));
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.remove(0);
        myArrayList.stream().forEach(System.out::println);

    }
}
