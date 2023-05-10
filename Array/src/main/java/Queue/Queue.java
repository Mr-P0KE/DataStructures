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
   * @Description  β��
   * @Param  * @param value
   * @Return boolean �ɹ�Ϊture
   */
    boolean offer(E value);
    /**
    * @Author Mr_Poke
    * @Date 13:34 2023/5/6
    * @Description   ��ȡɾ��ֵ�����򷵻�null
    * @Param  * @param
    * @Return E
    */
    E poll();
    /**
    * @Author Mr_Poke
    * @Date 13:36 2023/5/6
    * @Description �鿴ͷ��Ԫ�أ���ɾ��
    * @Param  * @param
    * @Return E
    */
    E peek();
    /**
    * @Author Mr_Poke
    * @Date 13:37 2023/5/6
    * @Description �������Ƿ�Ϊ�գ��� ture
    * @Param  * @param
    * @Return boolean
    */
    boolean isEmpty();
    /**
    * @Author Mr_Poke
    * @Date 14:01 2023/5/6
    * @Description  �������Ƿ�����
    * @Param  * @param
    * @Return boolean
    */
    boolean isFull();

}
