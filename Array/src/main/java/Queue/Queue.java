package Queue;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/6 13:33
 * @Description:
 */
public interface Queue<E> {
   /**
   * @Author Mr_Poke
   * @Date 13:34 2023/5/6
   * @Description  尾插
   * @Param  * @param value
   * @Return boolean 成功为ture
   */
    boolean offer(E value);
    /**
    * @Author Mr_Poke
    * @Date 13:34 2023/5/6
    * @Description   获取删除值，空则返回null
    * @Param  * @param
    * @Return E
    */
    E poll();
    /**
    * @Author Mr_Poke
    * @Date 13:36 2023/5/6
    * @Description 查看头部元素，不删除
    * @Param  * @param
    * @Return E
    */
    E peek();
    /**
    * @Author Mr_Poke
    * @Date 13:37 2023/5/6
    * @Description 检查队列是否为空，空 ture
    * @Param  * @param
    * @Return boolean
    */
    boolean isEmpty();
    /**
    * @Author Mr_Poke
    * @Date 14:01 2023/5/6
    * @Description  检查队列是否满了
    * @Param  * @param
    * @Return boolean
    */
    boolean isFull();

}
