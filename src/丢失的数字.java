/**
 * @author lyq on 2020-12-16 下午11:12
 * @desc 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。   
 * 进阶：  你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 */
public class 丢失的数字 {

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i=0;i<nums.length;i++) {
            n = i ^ nums[i] ^ n;
        }
        return n;
    }

}
