/**
 * @author lyq on 2020-07-27 11:48 下午
 * @desc 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 */
public class 缺失数字 {

    public static void main(String[] args) {
        int[] arr = {3,0,1};
        int res = missingNumber(arr);
    }

    /**
     * 数学计算法
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int sum = (nums.length+1)*nums.length/2;
        for (int i : nums) {
            sum -= i;
        }
        return sum;
    }

    /**
     * 位运算法：两个相同的数做异或元素为0
     * @param nums
     * @return
     */
    public static int bitCal(int[] nums) {
        int res = nums.length;
        for (int i=0;i<nums.length;i++) {
            res ^= nums[i]^i;
        }
        return res;
    }

}
