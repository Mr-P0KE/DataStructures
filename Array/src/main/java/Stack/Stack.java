package Stack;

/**
 * @Author: Mr_Poke
 * @Date: 2023/4/28 19:33
 * @Description: 栈
 */
public interface Stack<E> {
    /**
    * @Author Mr_Poke
    * @Date 16:01 2023/5/6
    * @Description  添加元素
    * @Param  * @param value
    * @Return boolean
    */
    boolean push(E value);
   /**
   * @Author Mr_Poke
   * @Date 16:01 2023/5/6
   * @Description 弹出元素
   * @Param  * @param
   * @Return boolean
   */
    E pop();
    /**
    * @Author Mr_Poke
    * @Date 16:02 2023/5/6
    * @Description 查看栈顶元素
    * @Param  * @param
    * @Return E
    */
    E peek();
   /**
   * @Author Mr_Poke
   * @Date 16:02 2023/5/6
   * @Description 是否为空
   * @Param  * @param
   * @Return boolean
   */
    boolean isEmpty();

    /**
    * @Author Mr_Poke
    * @Date 16:02 2023/5/6
    * @Description  是否为满
    * @Param  * @param
    * @Return boolean
    */
    boolean isFull();
}
