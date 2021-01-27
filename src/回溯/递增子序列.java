package 回溯;

import java.util.*;

/**
 * @author lyq on 2021-01-27 下午8:52
 * @desc 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 */
public class 递增子序列 {

    private static final List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> findSubsequences(int[] arr) {
        if (arr.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        int start = 0;
        trace(arr, start, list);
        return res;
    }

    private static void trace(int[] arr, int start, List<Integer> list) {
        if (list.size() >= 2) {
            res.add(new ArrayList<>(list));
        }
        // 允许递归出现重复元素，不允许同一层选取相同元素
        Set<Integer> set = new HashSet<>();
        for (int i=start;i<arr.length;i++) {
            if(set.contains(arr[i])) {
                continue;
            } else if (list.size() == 0 || arr[i] >= list.get(list.size()-1)) {
                set.add(arr[i]);
                list.add(arr[i]);
                trace(arr, i+1, list);
                list.remove(list.size()-1);
            } else {
                continue;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 7, 7};
        findSubsequences(arr);
    }

}
