import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lyq on 2020-07-21 10:54 下午
 * @desc 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
 */
public class 最长公共前缀 {

    public static void main(String[] args) {
        String s = "helloworld";
        System.out.println(s.substring(0, 1));
    }

    public static String solve(String[] arr) {
        String res = "";
        if (arr.length == 0) {
            return res;
        }
        Arrays.sort(arr, Comparator.comparing(String::length));
        String standard = arr[0];
        boolean flag = true;
        for (int i=1;i<=standard.length();i++) {
            String subStr = standard.substring(0, i);
            for (int j=1;j<arr.length;j++) {
                if (!arr[j].startsWith(subStr)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            } else {
                res = subStr;
            }
        }
        return res;
    }

}
