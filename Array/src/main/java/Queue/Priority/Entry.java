package Queue.Priority;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/7 12:42
 * @Description:
 */
public class Entry<E> implements Priority{
    private E  val;
    private int priority;

    public Entry(E val, int priority) {
        this.val = val;
        this.priority = priority;
    }

    @Override
    public int priority() {
        return this.priority;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "val=" + val +
                ", priority=" + priority +
                '}';
    }
}
