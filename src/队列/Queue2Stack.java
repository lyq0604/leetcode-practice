package 队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lyq on 2021-01-16 下午8:10
 * @desc 队列实现栈
 */
public class Queue2Stack {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    private void add(Integer i) {
        queue1.add(i);
    }

    private Integer poll() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        Integer item = queue1.poll();
        while (queue2.size() > 0) {
            queue1.add(queue2.poll());
        }
        return item;
    }

    public static void main(String[] args) {
        Queue2Stack queue2Stack = new Queue2Stack();
        for (int i=0;i<5;i++) {
            queue2Stack.add(i);
        }
        for (int i=0;i<5;i++) {
            System.out.println(queue2Stack.poll());
        }
    }

}
