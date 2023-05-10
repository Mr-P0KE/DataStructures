package Dueue;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/6 18:02
 * @Description: 双端队列
 */
public interface Deque<E> {
    /**
    * @Author Mr_Poke
    * @Date 18:04 2023/5/6
    * @Description  头部插入
    * @Param  * @param e
    * @Return boolean
    */
    boolean offerFirst(E e);
    /**
    * @Author Mr_Poke
    * @Date  2023/5/6
    * @Description  尾部插入
    * @Param  * @param e
    * @Return boolean
    */
    boolean offerLast(E e);
    /**
    * @Author Mr_Poke
    * @Date 18:05 2023/5/6
    * @Description 取出头部元素
    * @Param  * @param
    * @Return E
    */
    E pollFirst();

    /**
    * @Author Mr_Poke
    * @Date 18:05 2023/5/6
    * @Description  取出尾部元素
    * @Param  * @param
    * @Return E
    */
    E pollLast();
    /**
    * @Author Mr_Poke
    * @Date 18:06 2023/5/6
    * @Description 查看头部元素
    * @Param  * @param
    * @Return E
    */
    E peekFirst();

    /**
    * @Author Mr_Poke
    * @Date 18:06 2023/5/6
    * @Description  查看尾部元素
    * @Param  * @param
    * @Return E
    */
    E peekLast();
    /**
    * @Author Mr_Poke
    * @Date 18:06 2023/5/6
    * @Description  判断是否为空
    * @Param  * @param
    * @Return boolean
    */
    boolean isEmpty();

    /**
    * @Author Mr_Poke
    * @Date 18:07 2023/5/6
    * @Description  判断是否为满
    * @Param  * @param
    * @Return boolean
    */
    boolean isFull();
}
