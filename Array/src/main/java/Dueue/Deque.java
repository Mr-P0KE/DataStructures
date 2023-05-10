package Dueue;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/6 18:02
 * @Description: ˫�˶���
 */
public interface Deque<E> {
    /**
    * @Author Mr_Poke
    * @Date 18:04 2023/5/6
    * @Description  ͷ������
    * @Param  * @param e
    * @Return boolean
    */
    boolean offerFirst(E e);
    /**
    * @Author Mr_Poke
    * @Date  2023/5/6
    * @Description  β������
    * @Param  * @param e
    * @Return boolean
    */
    boolean offerLast(E e);
    /**
    * @Author Mr_Poke
    * @Date 18:05 2023/5/6
    * @Description ȡ��ͷ��Ԫ��
    * @Param  * @param
    * @Return E
    */
    E pollFirst();

    /**
    * @Author Mr_Poke
    * @Date 18:05 2023/5/6
    * @Description  ȡ��β��Ԫ��
    * @Param  * @param
    * @Return E
    */
    E pollLast();
    /**
    * @Author Mr_Poke
    * @Date 18:06 2023/5/6
    * @Description �鿴ͷ��Ԫ��
    * @Param  * @param
    * @Return E
    */
    E peekFirst();

    /**
    * @Author Mr_Poke
    * @Date 18:06 2023/5/6
    * @Description  �鿴β��Ԫ��
    * @Param  * @param
    * @Return E
    */
    E peekLast();
    /**
    * @Author Mr_Poke
    * @Date 18:06 2023/5/6
    * @Description  �ж��Ƿ�Ϊ��
    * @Param  * @param
    * @Return boolean
    */
    boolean isEmpty();

    /**
    * @Author Mr_Poke
    * @Date 18:07 2023/5/6
    * @Description  �ж��Ƿ�Ϊ��
    * @Param  * @param
    * @Return boolean
    */
    boolean isFull();
}
