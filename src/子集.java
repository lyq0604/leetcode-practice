import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lyq on 2020-07-29 10:16 下午
 * @desc 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 */
public class 子集 {

    public static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        // subsets1(nums);
        subsets2(nums);
    }

    /**
     * 排列组合
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 空集
        res.add(new ArrayList<>());
        if (nums.length == 0) {
            return res;
        }
        for (int n : nums) {
            int size = res.size();
            for (int i = 0; i< size; i++) {
                List<Integer> tmp = new ArrayList<>(res.get(i));
                tmp.add(n);
                res.add(tmp);
            }
        }
        return res;
    }

    /**
     * 回溯
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        List<Integer> trace = new LinkedList<>();
        track(nums, 0, trace);
        return result;
    }

    /**
     * @param nums
     * @param index 当前遍历元素索引
     * @param trace 追踪元素记录
     */
    private static void track(int[] nums, int index, List<Integer> trace) {
        result.add(new LinkedList<>(trace));
        for (int i=index;i<nums.length;i++) {
            // 选择
            trace.add(nums[i]);
            // 回溯
            track(nums, i+1, trace);
            // 撤销选择
            trace.remove(trace.size()-1);
        }
    }

}
