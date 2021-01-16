package 队列;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lyq on 2021-01-16 下午9:11
 * @desc 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
 * 滑动窗口每次只向右移动一位。  返回滑动窗口中的最大值。
 */
public class 滑动窗口最大值 {

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] maxSlidingWindow = maxSlidingWindow(arr, 3);
        System.out.println(Arrays.toString(maxSlidingWindow));
    }

    /**
     * 通过维护一个单调递减的双端队列实现保存滑动窗口最大值
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return nums;
        int[] arr = new int[len - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        // 前k个元素入队
        for (int i=0;i<k;i++) {
            // 如果插入元素小于队尾元素,则从尾部删除
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.offer(nums[i]);
        }
        int arr_idx = 0;
        arr[arr_idx++] = deque.peekFirst();
        // i++表示窗口后边界
        for (int i=k;i<len;i++) {
            // 如果窗口的前一元素与队头元素相同，表示该队头的元素不可能是现窗口中的最大值，所以将该值从队头移除
            if (nums[i-k] == deque.peekFirst()) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.offer(nums[i]);
            arr[arr_idx++] = deque.peekFirst();
        }
        return arr;
    }

}
