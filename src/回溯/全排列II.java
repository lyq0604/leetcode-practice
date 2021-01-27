package 回溯;

import java.util.*;

/**
 * @author lyq on 2021-01-27 下午10:10
 * @desc 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class 全排列II {

    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> permuteUnique(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> idxSet = new LinkedHashSet<>();
        Arrays.sort(arr);
        trace(arr, list, idxSet);
        return res;
    }

    private static void trace(int[] arr, List<Integer> list, Set<Integer> set) {
        if (list.size() == arr.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<arr.length;i++) {
            // 保证递归不会选到同一位置上的元素
            if (set.contains(i)) {
                continue;
            }
            // 防止选择值相同的元素放在位置：如果 set.contains(i-1) 成立，表示即使值相同，但前一相同的值被放置在了结果集中的其他位置，该元素可以被选取
            if (i>0 && arr[i]==arr[i-1] && !set.contains(i-1)) {
                continue;
            }
            list.add(arr[i]);
            set.add(i);
            trace(arr, list, set);
            set.remove(i);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        permuteUnique(arr);
    }

}
