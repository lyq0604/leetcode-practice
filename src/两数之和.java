import java.util.HashMap;
import java.util.Map;

/**
 * @author lyq on 2020-07-23 9:06 下午
 * @desc 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 */
public class 两数之和 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                res =  new int[]{i, map.get(nums[i])};
                break;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return res;
    }

}
