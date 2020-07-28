import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lyq on 2020-07-28 9:48 下午
 * @desc 给定一个整数数组，判断是否存在重复元素。  如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 */
public class 存在重复元素 {

    /**
     * 解法：
     * (1) 哈希表法;
     * (2) 排序法;
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        boolean res = false;
        // Set<Integer> set = new HashSet<>();
        // for (int i : nums) {
        //     if (set.contains(i)) {
        //         return true;
        //     } else {
        //         set.add(i);
        //     }
        // }

        Arrays.sort(nums);
        for (int i=1;i<nums.length;i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }
        return res;
    }

}
