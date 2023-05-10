package Queue;


/**
 * @Author: Mr_Poke
 * @Date: 2023/4/28 19:33
 * @Description: 数组模拟队列,但是在取出元素后，无法在原数组的下标添加元素。
 */
public class ArrayQueue {

    /**
     * TODO 最大容量
     */
    private int maxSize;
    /**
     * TODO 头指针,指向队列头元素的前一个元素
     */
    private int front;
    /**
     * TODO 尾指针，指向队列尾部元素
     */
    private int rear;

    /**
     * TODO 数组，模拟队列
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
    * @Description  判断队列是否满了
    * @Param  * @param
    * @Return boolean
    */
    public boolean isFull(){
        return rear == maxSize -1;
    }
    /**
    * @Author Mr_Poke
    * @Date 19:38 2023/4/28
    * @Description  判断队列是否为空
    * @Param  * @param
    * @Return boolean
    */
    public boolean isEmpty(){
        return front == rear;
    }
    /**
    * @Author Mr_Poke
    * @Date 19:40 2023/4/28
    * @Description 添加数据
    * @Param  * @param
    * @Return void
    */
    public void addQueue(int val){
        if(isFull())
            throw new RuntimeException("队列满，无法存放");
        else {
            ++rear;
            arr[rear] = val;
        }
    }
    /**
    * @Author Mr_Poke
    * @Date 19:42 2023/4/28
    * @Description  取数据
    * @Param  * @param
    * @Return int
    */
    public int getVal(){
        if(isEmpty())
            throw new RuntimeException("队列为空，无法获取");
        else {
            front++;
            return arr[front];
        }
    }
    /**
    * @Author Mr_Poke
    * @Date 19:44 2023/4/28
    * @Description  查看队列元素
    * @Param  * @param
    * @Return void
    */
    public void showQueue(){
        if(isEmpty())
            System.out.println("队列为空");
        else {
            System.out.println(this);
        }
    }
    /**
    * @Author Mr_Poke
    * @Date 19:46 2023/4/28
    * @Description  查看头部数据
    * @Param  * @param
    * @Return int
    */
    public int peek(){
        if(isEmpty())
            throw new RuntimeException("队列为空");
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
