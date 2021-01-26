package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyq on 2021-01-26 下午8:20
 * @desc 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。  返回 s 所有可能的分割方案。
 */
public class 分割回文串 {

    private static List<List<String>> res = new ArrayList<>();

    public static List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        int start = 0;
        trace(s, start, list);
        return res;
    }

    /**
     * @param start 截取开始的位置
     */
    private static void trace(String s, int start, List<String> list) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=start;i<s.length();i++) {
            if (!isBack(s, start, i)) {
                continue;
            }
            list.add(s.substring(start, i+1));
            trace(s, i+1, list);
            list.remove(list.size()-1);
        }
    }

    public static boolean isBack(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> list = partition(s);
    }

}
