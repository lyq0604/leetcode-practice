package 贪心;

/**
 * @author lyq on 2021-01-31 下午9:04
 * @desc 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class 最大子序列 {

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(arr);
        System.out.println(res);
    }

    public static int maxSubArray(int[] arr) {
        int res = arr[0];
        int tmpSum = res;
        for (int i=1;i<arr.length;i++) {
            if (tmpSum > 0) {
                tmpSum += arr[i];
            } else {
                tmpSum = arr[i];
            }
            res = Math.max(res, tmpSum);
        }
        return res;
    }

}
