package 回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lyq on 2021-01-27 下午9:36
 * @desc 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class 全排列 {

    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> permute(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        trace(arr, list, set);
        return res;
    }

    private static void trace(int[] arr, List<Integer> list, Set<Integer> set) {
        if (list.size() == arr.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<arr.length;i++) {
            if (set.contains(arr[i])) {
                continue;
            }
            set.add(arr[i]);
            list.add(arr[i]);
            trace(arr, list, set);
            list.remove(list.size()-1);
            set.remove(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        permute(arr);
    }

}
