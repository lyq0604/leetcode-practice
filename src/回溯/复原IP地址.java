package 回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lyq on 2021-01-26 下午9:17
 * @desc 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 */
public class 复原IP地址 {

    private static List<String> res = new ArrayList<>();

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() < 3 || s.length() > 12) return res;
        List<String> list = new ArrayList<>();
        // 分割位置
        int start = 0;
        // 第几段
        int seg = 0;
        trace(s, start, seg, list);
        return res;
    }

    public static void trace(String s, int start, int seg, List<String> list) {
        if (seg == 4 && start == s.length()) {
            res.add(list.stream().collect(Collectors.joining(".")));
        }
        for (int i=start;i<s.length();i++) {
            if (s.charAt(start) == '0' && i != start) {
                continue;
            }
            String sub = s.substring(start, i + 1);
            if (sub.length() > 3 || Integer.valueOf(sub) > 255) {
                continue;
            }
            list.add(sub);
            trace(s, i+1, seg+1, list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        String s = "0000";
        restoreIpAddresses(s);
    }

}
