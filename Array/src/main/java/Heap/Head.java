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
    * @Description ����
    * @Param  * @param
    * @Return void
    */
    void heapify();
    /**
    * @Author Mr_Poke
    * @Date 18:43 2023/5/7
    * @Description ȡ��Ԫ��
    * @Param  * @param
    * @Return int
    */
    int poll();

    /**
    * @Author Mr_Poke
    * @Date 18:43 2023/5/7
    * @Description  ��������ȡ��Ԫ��
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
    * @Description �滻�Ѷ�Ԫ��
    * @Param  * @param val
    * @Return void
    */
    void replace(int val);

}
