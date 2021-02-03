package 贪心;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lyq on 2021-02-02 下午8:55
 * @desc 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 */
public class 划分字母区间 {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> res = partitionLabels(s);
        System.out.println(res);
    }

    public static List<Integer> partitionLabels(String s) {
        if (s.length() == 0) return null;
        Map<Character, Integer> pos = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            pos.put(s.charAt(i), i);
        }
        List<Integer> res = new ArrayList<>();
        int right = pos.get(s.charAt(0));
        // 上一边界
        int pre = -1;
        for (int i=0;i<s.length();i++) {
            if (i==right) {
                res.add(right-pre);
                pre = right;
            } else {
                right = Math.max(right, pos.get(s.charAt(i)));
            }
        }
        if (right != pre) {
            res.add(right-pre);
        }
        return res;
    }

}
