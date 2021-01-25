package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyq on 2021-01-25 下午9:06
 * @desc 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。  candidates 中的数字可以无限制重复被选取。
 * 说明：
 *  所有数字（包括 target）都是正整数。
 *  解集不能包含重复的组合。
 */
public class 组合总和II {

    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        int start = 0;
        trace(candidates, start, target, list);
        return res;
    }

    /**
     * 设置start的目的是限制仅从当前元素位置往后递归，防止重复结果
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
            list.add(candidates[i]);
            trace(candidates, i, target-candidates[i], list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        combinationSum(arr, target);
    }

}
