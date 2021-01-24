package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lyq on 2021-01-24 下午9:13
 * @desc  给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class 组合 {

    public static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        if (n == k) {
            for (int i=1;i<=n;i++) {
                list.add(i);
            }
            res.add(list);
            return res;
        }
        int start = 1;
        trace(n, k, start, list);
        return res;
    }

    private static void trace(int n, int k, int start, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=start;i<=n-(k-list.size())+1;i++) {
            list.add(i);
            trace(n, k, ++start, list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        combine(n, k);
    }

}
