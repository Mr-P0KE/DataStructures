package Heap;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/7 18:40
 * @Description:
 */
public interface Head {
    /**
    * @Author Mr_Poke
    * @Date 18:43 2023/5/7
    * @Description 建堆
    * @Param  * @param
    * @Return void
    */
    void heapify();
    /**
    * @Author Mr_Poke
    * @Date 18:43 2023/5/7
    * @Description 取出元素
    * @Param  * @param
    * @Return int
    */
    int poll();

    /**
    * @Author Mr_Poke
    * @Date 18:43 2023/5/7
    * @Description  按照索引取出元素
    * @Param  * @param index
    * @Return int
    */
    int poll(int index);

    int peek();
    boolean offer(int val);

    boolean isFull();

    boolean isEmpty();
    /**
    * @Author Mr_Poke
    * @Date 19:53 2023/5/7
    * @Description 替换堆顶元素
    * @Param  * @param val
    * @Return void
    */
    void replace(int val);

}
