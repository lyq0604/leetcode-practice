package 哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lyq on 2021-01-11 下午9:23
 * @desc 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：  答案中不可以包含重复的四元组。
 */
public class 四数之和1 {

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> list = fourSum(arr, target);
    }

    /**
     * 解题思路与三数之和类似，双重循环先固定前两个数，后两个数利用双指针移动获取
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i=0;i<len-3;i++) {
            if (i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            if ((nums[i]+nums[i+1]+nums[i+2]+nums[i+3])>target) {
                break;
            }
            if ((nums[i]+nums[len-1]+nums[len-2]+nums[len-3]) < target) {
                continue;
            }
            for (int j=i+1;j<len-2;j++) {
                if (j>(i+1) && nums[j]==nums[j-1]) {
                    continue;
                }
                if ((nums[i]+nums[j]+nums[j+1]+nums[j+2])>target) {
                    break;
                }
                if ((nums[i]+nums[j]+nums[len-1]+nums[len-2])<target) {
                    continue;
                }
                int left = j+1;
                int right = len-1;
                while (left<right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left<right && nums[left]==nums[left+1]) {
                            left++;
                        }
                        left++;
                        while (left<right && nums[right]==nums[right-1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return res;
    }

}
