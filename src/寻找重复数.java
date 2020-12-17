/**
 * @author lyq on 2020-07-30 11:19 下午
 * @desc 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 */
public class 寻找重复数 {

    public int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right + left)/2;
            int count = 0;
            for (int i : nums) {
                if (i <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
