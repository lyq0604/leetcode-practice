package 字符串;

import java.util.Arrays;

/**
 * @author lyq on 2021-01-12 下午9:31
 * @desc 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */
public class 实现strStr函数 {

    public static void main(String[] args) {
        String s1 = "mississippi";
        String s2 = "issip";
        System.out.println(strStr(s1, s2));


        int[] next = next(s2.toCharArray(), s2.length());
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        if (needle.length() == 0) {
            return 0;
        }

        if (haystack.length() == 0 && needle.length() > 0) return -1;

        int[] next = buildNextArr(needle);

        for (int idx1 = 0, idx2 = 0;idx1 < haystack.length();) {
            if (haystack.charAt(idx1) == needle.charAt(idx2)) {
                idx1++;
                idx2++;
            } else {
                if (idx2 > 0) {
                    idx2 = next[idx2-1]+1;
                } else {
                    idx1++;
                }
                if (idx1 >= haystack.length()) return -1;
            }
            if (idx2 == needle.length()) {
                return idx1 - idx2;
            }
        }
        return -1;
    }

    /**
     * 构造next数组
     * @param needle
     * @return
     */
    public static int[] buildNextArr(String needle) {
        int len = needle.length();
        int[] arr = new int[len];
        for (int i=0;i<len;i++) {
            if (i == 0) {
                arr[i] = -1;
            }
            if (i == 1) {
                arr[i] = 0;
            }
            int val = 0;
            int low = 0;
            int high = i;
            while (low < high && needle.charAt(low++) == needle.charAt(high--)) {
                val++;
            }
            arr[i] = val-1;
        }
        return arr;
    }

    public static int[] next(char[] needle,int len) {
        //定义 next 数组
        int[] next = new int[len];
        // 初始化
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < len; ++i) {
            //我们此时知道了 [0,i-1]的最长前后缀，但是k+1的指向的值和i不相同时，我们则需要回溯
            //因为 next[k]就时用来记录子串的最长公共前后缀的尾坐标（即长度）
            //就要找 k+1前一个元素在next数组里的值,即next[k+1]
            while (k != -1 && needle[k + 1] != needle[i]) {
                k = next[k];
            }
            // 相同情况，就是 k的下一位，和 i 相同时，此时我们已经知道 [0,i-1]的最长前后缀
            //然后 k - 1 又和 i 相同，最长前后缀加1，即可
            if (needle[k+1] == needle[i]) {
                ++k;
            }
            next[i] = k;

        }
        return next;
    }

}
