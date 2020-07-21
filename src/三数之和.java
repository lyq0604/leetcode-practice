import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lyq on 2020-07-13 10:48 下午
 * @desc 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class 三数之和 {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3 || nums[0] > 0) {
            return res;
        }
        for (int i=0;i<nums.length-2;i++) {
            if (nums[i] > 0) {
                break;
            } else if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            } else {
                int left = i+1;
                int right = nums.length-1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[++left]);
                        while (left < right && nums[right] == nums[--right]);
                    } else if (sum < 0) {
                        while (left < right && nums[left] == nums[++left]);
                    } else {
                        while (left < right && nums[right] == nums[--right]);
                    }
                }
            }
        }
        return res;
    }

}
