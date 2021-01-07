package 数组;

/**
 * @author lyq on 2021-01-06 下午9:35
 * @desc 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 */
public class 长度最小的子数组 {

    public static void main(String[] args) {
        int[] arr = {2,0,5,3,1,4,8};
        System.out.println(subArr(arr, 9));
    }

    public static int subArr(int[] arr, int val) {
        int res = Integer.MAX_VALUE;
        int len = arr.length;
        if (len == 0) return res;
        int sum = 0;
        int start = 0;
        for(int end=0;end<len;end++) {
            sum += end;
            if (sum >= val) {
                res = end-start+1;
                while (start <= end) {
                    if (sum-arr[start] >= val) {
                        sum = sum-arr[start++];
                        res = Math.min(res, end-start+1);
                    } else {
                        break;
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
