import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lyq on 2020-07-27 10:17 下午
 * @desc 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class 字符串中的唯一字符 {

    public static void main(String[] args) {
        String s = "loveleetcode";
        int res = firstUniqChar(s);
    }

    public static int firstUniqChar(String s) {
        int res = -1;

        if (s == null || s.length() == 0) {
            return -1;
        }

        Map<Character, Integer> map = new LinkedHashMap<>();

        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], i);
            } else {
                map.put(chars[i], -1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1) {
                res = entry.getValue();
                break;
            }
        }
        return res;
    }

}
