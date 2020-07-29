/**
 * @author lyq on 2020-07-29 11:17 下午
 * @desc 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 */
public class 除自身以外数组的乘积 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        productExceptSelf(arr);
    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        // 存放该元素左侧各元素乘积
        int[] left = new int[len];
        left[0] = 1;
        for (int i = 1; i< len; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        // 存放该元素右侧各元素乘积
        int[] right = new int[len];
        right[len -1] = 1;
        for (int i=len-2;i>=0;i--) {
            right[i] = right[i+1] * nums[i+1];
        }
        int[] res = new int[len];
        for (int i=0;i<len;i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

}
