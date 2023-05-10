package Stack;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author: Mr_Poke
 * @Date: 2023/5/6 16:18
 * @Description:
 */
public class ArrayStack<E> implements Stack<E>,Iterable<E> {
    private E[] array;
    private int top;

    public ArrayStack(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E value) {
        if (isFull())
            return false;
        array[top++] = value;
        return true;
    }

    @Override
    public E pop() {
       if(isEmpty())
           return null;
       return array[--top];
    }

    @Override
    public E peek() {
        if (isEmpty())
            return null;
        return array[top-1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int i = top;
            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public E next() {
                return array[--i];
            }
        };
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new ArrayStack<Integer>(20);
        HashSet<Character> set = new HashSet<>();
        set.add('+');
        set.add('-');
        set.add('*');
        set.add('/');
        for(int i = 0;i < tokens.length;i++){
            char c = tokens[i].charAt(0);
            if(!set.contains(c))
                stack.push(Integer.parseInt(String.valueOf(c)));
            else{
                int x = stack.pop();
                System.out.println(x);
                int y = stack.pop();
                System.out.println(y);
                switch (c){
                    case '+':
                        stack.push(x +y);
                        break;
                    case '-':
                        stack.push(x -y);
                        break;
                    case '*':
                        stack.push(x *y);
                        break;
                    case '/':
                        stack.push(x /y);
                        break;
                }
            }
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        // return  (int)stack.pop();
        return 1;
    }

    public static void main(String[] args) {
       String[] c = {"2","1","+","3","*"};
       evalRPN(c);
    }
}
