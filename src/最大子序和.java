/**
 * @author lyq on 2020-07-24 9:12 下午
 * @desc 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class 最大子序和 {

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSum(arr);
    }

    public static int maxSum(int[] arr) {
        int res = arr[0];
        // int sum = arr[0];
        // for (int i=1;i<arr.length;i++) {
        //     if (sum < 0) {
        //         sum = arr[i];
        //     } else {
        //         sum += arr[i];
        //     }
        //     res = Math.max(res, sum);
        // }
        int tmp = arr[0];
        for (int i=1;i<arr.length;i++) {
            if (tmp < 0) {
                tmp = arr[i];
            } else {
                tmp += arr[i];
            }
            res = Math.max(res, tmp);
        }
        return res;
    }

}
