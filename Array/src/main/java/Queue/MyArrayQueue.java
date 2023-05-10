package Queue;

/**
 * @Author: Mr_Poke
 * @Date: 2023/4/28 22:39
 * @Description: 环形队列
 */
public class MyArrayQueue {
    /**
     * TODO 最大容量（max - 1），在判断时，预留空间表示是否满了（不预留空间则无法判断队列为空或者为满），所以最大容量 = max -1
     */
    private int maxSize;
    /**
     * TODO 头指针,指向队列头元素
     */
    private int front;
    /**
     * TODO 尾指针，指向队列尾部元素的后一个元素
     */
    private int rear;

    /**
     * TODO 数组，模拟队列
     */
    private int[] arr;

    public MyArrayQueue(int maxSize){
        //当队列满时，条件为 ：（rear + 1） % maxSize =  front （eg : maxSize 为10，那么rear最大为9，所以要+1取模）
        //当队列为空，条件为： `rear = front`
        // maxSize + 1 是因为我们要判断队列是否为空或者为满，需要预留一个空位
        //因为我们的rear指针指向最后一个元素的下一个地址
        //当size = 4时，我们rear此时指向 (3 +1) % 4 = 0，此时表示满了

        this.maxSize = maxSize + 1;
        arr = new int[maxSize + 1];
    }
    /**
     * @Author Mr_Poke
     * @Date 19:38 2023/4/28
     * @Description  判断队列是否满了
     * @Param  * @param
     * @Return boolean
     */
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
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
            arr[rear] = val;
            //考虑是否取模
            rear = (rear+1) % maxSize;
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
           int temp = front;
           front = (front+1) % maxSize;
           return arr[temp];
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
            return arr[front];
    }
    public int size(){
        // (rear +maxSize -front) %maxSize 表示有效数据个数
        return (rear + maxSize - front) % maxSize;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        // (rear +maxSize -front) %maxSize 表示有效数据个数
        for (int i = front; i <= front+size()-1; i++) {
            //arr[i%maxSize] 因为是环形的
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
