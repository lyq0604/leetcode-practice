/**
 * @author lyq on 2020-07-23 9:15 下午
 * @desc 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 */
public class 反转字符串 {

    public static void main(String[] args) {
        char[] chars = "helloq".toCharArray();
        reverseString(chars);
    }

    public static void reverseString(char[] s) {
        if (s.length < 1) {
            return;
        }
        int start = 0;
        int end = s.length - 1;
        int mid = s.length/2;
        while (start < mid) {
            char c = s[start];
            s[start] = s[end];
            s[end] = c;
            start++;
            end--;
        }
    }

}
