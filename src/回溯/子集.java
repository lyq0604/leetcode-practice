package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lyq on 2021-01-26 下午9:50
 * @desc 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。  说明：解集不能包含重复的子集。
 */
public class 子集 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        List<Integer> list = new ArrayList<>();
        trace(nums, start, list);
        return res;
    }

    private void trace(int[] nums, int start, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i=start;i<nums.length;i++) {
            // 如果存在重复元素
            if (i>start && nums[i]==nums[i-1]) {
                continue;
            }
            list.add(nums[i]);
            trace(nums, i+1, list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        子集 子集 = new 子集();
        int[] arr = {1,2,2};
        子集.subsets(arr);
    }
}
