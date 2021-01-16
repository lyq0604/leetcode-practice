package 栈;

import java.util.Stack;

/**
 * @author lyq on 2021-01-16 下午8:01
 * @desc 栈实现队列
 */
public class Stack2Queue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void add(Integer i) {
        stack1.add(i);
    }

    public Integer pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Stack2Queue stack2Queue = new Stack2Queue();
        for (int i=0;i<5;i++) {
            stack2Queue.add(i);
        }
        for (int i=0;i<3;i++) {
            System.out.println(stack2Queue.pop());
        }
        for (int i=5;i<8;i++) {
            stack2Queue.add(i);
        }
        for (int i=0;i<5;i++) {
            System.out.println(stack2Queue.pop());
        }
    }

}
