package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lyq on 2021-01-25 下午9:50
 * @desc 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。  candidates 中的每个数字在每个组合中只能使用一次。
 * 说明： 所有数字（包括目标数）都是正整数。 解集不能包含重复的组合。
 */
public class 组合总和III {

    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        int start = 0;
        Arrays.sort(candidates);
        trace(candidates, start, target, list);
        return res;
    }

    /**
     * @param candidates
     * @param start
     * @param target
     * @param list
     */
    public static void trace(int[] candidates, int start, int target, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }
        if (target < 0) {
            return;
        }
        for (int i=start;i<candidates.length;i++) {
            // 同层遇到相同元素则跳过,避免出现重复结果集
            if (i>start && candidates[i] == candidates[i-1]) {
                continue;
            }
            list.add(candidates[i]);
            trace(candidates, i+1, target-candidates[i], list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,5,2,1,2};
        int target = 5;
        combinationSum(arr, target);
    }

}
