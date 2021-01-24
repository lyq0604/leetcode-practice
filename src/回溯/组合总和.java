package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyq on 2021-01-24 下午9:46
 * @desc 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 */
public class 组合总和 {

    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum3(int k, int n) {
        int start = 1;
        List<Integer> list = new ArrayList<>();
        trace(k, n, start, list);
        return res;
    }

    private static void trace(int k, int need, int start, List<Integer> list) {
        if (list.size() == k && need == 0) {
            res.add(new ArrayList<>(list));
            return;
        } else if (list.size() == k || need <= 0) {
            return;
        }
        for (int i=start;i<=9;i++) {
            list.add(i);
            trace(k, need-i, ++start, list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int k=3;
        int n=9;
        combinationSum3(k, n);
    }

}
