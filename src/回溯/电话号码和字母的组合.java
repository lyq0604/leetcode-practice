package 回溯;

import java.util.*;

/**
 * @author lyq on 2021-01-24 下午10:02
 * @desc 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。  给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class 电话号码和字母的组合 {

    private static Map<Integer, List<Character>> data = new HashMap<>();

    private static List<List<Character>> res = new ArrayList<>();

    static {
        data.put(2, Arrays.asList('a', 'b', 'c'));
        data.put(3, Arrays.asList('d', 'e', 'f'));
        data.put(4, Arrays.asList('g', 'h', 'i'));
        data.put(5, Arrays.asList('j', 'k', 'l'));
        data.put(6, Arrays.asList('m', 'n', 'o'));
        data.put(7, Arrays.asList('p', 'q', 'r', 's'));
        data.put(8, Arrays.asList('t', 'u', 'v'));
        data.put(9, Arrays.asList('w', 'x', 'y', 'z'));
    }

    public static List<List<Character>> letterCombinations(String s) {
        int idx = 0;
        List<Character> list = new ArrayList<>();
        trace(s, idx, list);
        return res;
    }

    public static void trace(String s, int idx, List<Character> list) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        } else if (idx > s.length()) {
            return;
        }
        Integer num = Integer.valueOf(String.valueOf(s.charAt(idx)));
        List<Character> chars = data.get(num);
        for (int i=0;i<chars.size();i++) {
            list.add(chars.get(i));
            trace(s, idx+1, list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        String s = "23";
        letterCombinations(s);
    }

}
