package 字符串;

/**
 * @author lyq on 2021-01-12 下午8:30
 * @desc 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class 替换空格 {

    public static void main(String[] args) {
        String s = "We are happy";
        String s1 = replaceBlank(s);
        System.out.println(s1);
    }

    /**
     * 1、计算将空格替换为 %20 后的字符串长度; 2、从新字符串的最后一位往前遍历设置值
     * @param s
     * @return
     */
    public static String replaceBlank(String s) {
        int count = 0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }
        int len1 = s.length();
        int len2 = len1 + 2 * count;
        char[] target = new char[len2];
        int idx1 = len1 - 1;
        int idx2 = len2 - 1;
        for (; idx1 < idx2; idx2--,idx1--) {
            if (s.charAt(idx1) != ' ') {
                target[idx2] = s.charAt(idx1);
            } else {
                target[idx2--] = '0';
                target[idx2--] = '2';
                target[idx2] = '%';
            }
        }
        while (idx1 >= 0) {
            target[idx1] = s.charAt(idx1);
            idx1--;
        }
        return String.valueOf(target);
    }

}
