package Queue;

/**
 * @Author: Mr_Poke
 * @Date: 2023/4/28 22:39
 * @Description: ���ζ���
 */
public class MyArrayQueue {
    /**
     * TODO ���������max - 1�������ж�ʱ��Ԥ���ռ��ʾ�Ƿ����ˣ���Ԥ���ռ����޷��ж϶���Ϊ�ջ���Ϊ����������������� = max -1
     */
    private int maxSize;
    /**
     * TODO ͷָ��,ָ�����ͷԪ��
     */
    private int front;
    /**
     * TODO βָ�룬ָ�����β��Ԫ�صĺ�һ��Ԫ��
     */
    private int rear;

    /**
     * TODO ���飬ģ�����
     */
    private int[] arr;

    public MyArrayQueue(int maxSize){
        //��������ʱ������Ϊ ����rear + 1�� % maxSize =  front ��eg : maxSize Ϊ10����ôrear���Ϊ9������Ҫ+1ȡģ��
        //������Ϊ�գ�����Ϊ�� `rear = front`
        // maxSize + 1 ����Ϊ����Ҫ�ж϶����Ƿ�Ϊ�ջ���Ϊ������ҪԤ��һ����λ
        //��Ϊ���ǵ�rearָ��ָ�����һ��Ԫ�ص���һ����ַ
        //��size = 4ʱ������rear��ʱָ�� (3 +1) % 4 = 0����ʱ��ʾ����

        this.maxSize = maxSize + 1;
        arr = new int[maxSize + 1];
    }
    /**
     * @Author Mr_Poke
     * @Date 19:38 2023/4/28
     * @Description  �ж϶����Ƿ�����
     * @Param  * @param
     * @Return boolean
     */
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
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
            arr[rear] = val;
            //�����Ƿ�ȡģ
            rear = (rear+1) % maxSize;
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
           int temp = front;
           front = (front+1) % maxSize;
           return arr[temp];
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
            return arr[front];
    }
    public int size(){
        // (rear +maxSize -front) %maxSize ��ʾ��Ч���ݸ���
        return (rear + maxSize - front) % maxSize;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        // (rear +maxSize -front) %maxSize ��ʾ��Ч���ݸ���
        for (int i = front; i <= front+size()-1; i++) {
            //arr[i%maxSize] ��Ϊ�ǻ��ε�
            s.append(arr[i % maxSize]);
            s.append(",");
        }
        String substring = s.substring(0, s.lastIndexOf(","));
        return "ArrayQueue{" +
                substring +
                '}';
    }

    public static void main(String[] args) {
        MyArrayQueue myArrayQueue = new MyArrayQueue(4);
        for (int i = 0; i < 4; i++) {
            myArrayQueue.addQueue(i);
        }
//        myArrayQueue.getVal();
//        myArrayQueue.getVal();
//        myArrayQueue.getVal();
//        myArrayQueue.getVal();
//        myArrayQueue.getVal();
        System.out.println(myArrayQueue.toString());
    }
}
