package 字符串;

/**
 * @author lyq on 2021-01-15 下午9:27
 * @desc KMP算法
 */
public class KMP {

    /**
     * kmp匹配算法
     * @param s1 主串
     * @param s2 模式串
     * @return
     */
    public static int kmp(char[] s1, char[] s2) {
        // 构建next数组
        int[] next = buildNext(s2);
        int m = s1.length;
        int n = s2.length;
        // 主串字符位置
        int i;
        // 模式串字符下标
        int j = 0;
        for (i=0;i<m;i++) {
            while (j > 0 && s1[i] != s2[j]) {
                j = next[j-1] + 1;
            }
            if (s1[i] == s1[j]) {
                j++;
            }
            // 匹配完成
            if (j==n) {
                return i-n+1;
            }
        }
        return -1;
    }

    /**
     * next数组：
     *    下标表示好前缀的最后一个字符的下标;
     *    值表示好前缀的前缀子串与后缀子串中匹配且长度最长时，前缀子串的最后一个字符的下标。
     * @param s2 模式串数组
     * @return
     */
    private static int[] buildNext(char[] s2) {
        int len = s2.length;
        int[] next = new int[len];
        next[0] = -1;
        // 前一字符最长可匹配前缀子串的结束下标
        int k = -1;
        for (int i=1;i<len;i++) {
            while (k!=-1 && s2[k+1]!=s2[i]) {
                // 如果该字符的前一字符的最长可匹配前缀子串(A)的下一字符与该字符不等,则比较A的最长可匹配前缀子串的下一字符与该字符是否相同
                k = next[k];
            }
            if (s2[k+1] == s2[i]) {
                k++;
            }
            next[i] = k;
        }

        return next;
    }

}
