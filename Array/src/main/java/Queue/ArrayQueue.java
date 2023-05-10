package Queue;


/**
 * @Author: Mr_Poke
 * @Date: 2023/4/28 19:33
 * @Description: ����ģ�����,������ȡ��Ԫ�غ��޷���ԭ������±����Ԫ�ء�
 */
public class ArrayQueue {

    /**
     * TODO �������
     */
    private int maxSize;
    /**
     * TODO ͷָ��,ָ�����ͷԪ�ص�ǰһ��Ԫ��
     */
    private int front;
    /**
     * TODO βָ�룬ָ�����β��Ԫ��
     */
    private int rear;

    /**
     * TODO ���飬ģ�����
     */
    private int[] arr;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front  = -1;
        rear = -1;
    }
    /**
    * @Author Mr_Poke
    * @Date 19:38 2023/4/28
    * @Description  �ж϶����Ƿ�����
    * @Param  * @param
    * @Return boolean
    */
    public boolean isFull(){
        return rear == maxSize -1;
    }
    /**
    * @Author Mr_Poke
    * @Date 19:38 2023/4/28
    * @Description  �ж϶����Ƿ�Ϊ��
    * @Param  * @param
    * @Return boolean
    */
    public boolean isEmpty(){
        return front == rear;
    }
    /**
    * @Author Mr_Poke
    * @Date 19:40 2023/4/28
    * @Description �������
    * @Param  * @param
    * @Return void
    */
    public void addQueue(int val){
        if(isFull())
            throw new RuntimeException("���������޷����");
        else {
            ++rear;
            arr[rear] = val;
        }
    }
    /**
    * @Author Mr_Poke
    * @Date 19:42 2023/4/28
    * @Description  ȡ����
    * @Param  * @param
    * @Return int
    */
    public int getVal(){
        if(isEmpty())
            throw new RuntimeException("����Ϊ�գ��޷���ȡ");
        else {
            front++;
            return arr[front];
        }
    }
    /**
    * @Author Mr_Poke
    * @Date 19:44 2023/4/28
    * @Description  �鿴����Ԫ��
    * @Param  * @param
    * @Return void
    */
    public void showQueue(){
        if(isEmpty())
            System.out.println("����Ϊ��");
        else {
            System.out.println(this);
        }
    }
    /**
    * @Author Mr_Poke
    * @Date 19:46 2023/4/28
    * @Description  �鿴ͷ������
    * @Param  * @param
    * @Return int
    */
    public int peek(){
        if(isEmpty())
            throw new RuntimeException("����Ϊ��");
        else
            return arr[front+1];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i <= rear; i++) {
            s.append(arr[i]);
            s.append(",");
        }
        String substring = s.substring(0, s.lastIndexOf(","));
        return "ArrayQueue{" +
                substring +
                '}';
    }

}
