package 数组;

/**
 * @author lyq on 2020-07-28 10:33 下午
 * @desc 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class 反转数组 {

    public static void main(String[] args) {
        int[] arr = {1,2};
        rotate(arr, 3);
    }

    public static void rotate(int[] nums, int k) {

        if (nums.length < 2) {
            return;
        }
        if (k == 0) {
            return;
        }

        k = k%nums.length;

        roll(nums, 0, nums.length-1);
        roll(nums, 0, k-1);
        roll(nums, k, nums.length-1);
    }


    private static void roll(int[] nums, int start, int end) {
        if (end <= start) return;
        int mid = (end - start)/2 + start;
        for (int i=start;i<=mid;i++) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
