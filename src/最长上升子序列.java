/**
 * @author lyq on 2020-07-24 9:25 下午
 * @desc 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 解题思路：第i个元素对应最长子序列为其之前元素中小于该值的元素对应的最长长度+1
 */
public class 最长上升子序列 {

    public static void main(String[] args) {
        int[] arr = {4,10,4,3,8,9};
        int res = lengthOfLIS(arr);
        System.out.println(res);
    }

    public static int lengthOfLIS(int[] arr) {
        if (arr.length == 0) return 0;
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int res = 1;
        for (int i=1;i<arr.length;i++) {
            int cur = arr[i];
            dp[i] = 1;
            for (int j=0;j<i;j++) {
                if (arr[j] < cur) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
