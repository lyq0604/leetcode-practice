package 字符串;

/**
 * @author lyq on 2021-01-14 下午8:47
 * @desc
 */
public class BM {

    /**
     * 查找s2在s1中出现的第一个位置
     * @param s1 主串
     * @param s2 模式串
     * @return
     */
    public static int strMatch(char[] s1, char[] s2) {
        // 记录模式串中每个字符出现的最后位置
        int[] posArr = buildArr(s2);
        int m = s1.length;
        int n = s2.length;
        int[] suffix = new int[n];
        boolean[] prefix = new boolean[n];
        buildSuffixAndPrefix(s2, suffix, prefix);
        // 模式串与主串匹配时模式串首字符位置
        int i = 0;
        while (i<=m-n) {
            // 坏字符位置
            int j;
            // 从模式串尾字符开始匹配
            for (j=n-1;j>=0;j--) {
                if (s2[j]!=s1[i+j]) {
                    break;
                }
            }
            // 完全匹配
            if (j < 0) return i;
            // 坏字符规则移动位数移动量
            int x = j - posArr[(int)s1[i+j]];
            // 好后缀移动量
            int y = 0;
            // 存在好后缀的情况
            if (j < m-1) {
                y = moveByGS(j, n, suffix, prefix);
            }
             i = i + Math.max(x, y);
        }
        return -1;
    }

    /**
     * 模式串根据好后缀规则移动的位数
     * @param j 坏字符在模式串中的位置
     * @param n 模式串长度
     * @param suffix
     * @param prefix
     * @return
     */
    private static int moveByGS(int j, int n, int[] suffix, boolean[] prefix) {
        // 好后缀长度
        int k = n-1-j;
        // 如果存在与好后缀匹配的子串，将模式串移动至 匹配子串 与 好后缀 重合的位置
        if (suffix[k] != -1) {
            return j-suffix[k] + 1;
        }
        // 好后缀的后缀子串 b[r, n-1]（其中，r 取值从 j+2 到 n-1）的长度 k=n-r，
        // 如果 prefix[k]等于 true，表示长度为 k 的后缀子串，有可匹配的前缀子串，这样我们可以把模式串后移 r 位。
        for (int r=j+2;r<=n-1;r++) {
            if (prefix[n-r]) {
                return r;
            }
        }
        return n;
    }

    /**
     * 构建数组用于快速查找模式串中坏字符的位置
     * @param chars 模式串
     * @return
     */
    public static int[] buildArr(char[] chars) {
        int[] arr = new int[256];
        for (int i=0;i<256;i++) {
            arr[i] = -1;
        }
        for (int i=0;i<chars.length;i++) {
            int ascii = chars[i];
            arr[ascii] = i;
        }
        return arr;
    }

    /**
     * 构建suffix与prefix数组
     * @param chars
     * @param suffix 记录模式串中，与各长度后缀子串匹配的子串起始位置
     * @param prefix 记录模式串中，是否存在与各长度后缀子串匹配的前缀子串
     *
     *  拿下标从 0 到 i 的子串（i 可以是 0 到 m-2）与整个模式串，求公共后缀子串。
     *  如果公共后缀子串的长度是 k，那我们就记录 suffix[k]=j（j 表示公共后缀子串的起始下标）。
     *  如果 j 等于 0，也就是说，公共后缀子串也是模式串的前缀子串，我们就记录 prefix[k]=true。
     */
    public static void buildSuffixAndPrefix(char[] chars, int[] suffix, boolean[] prefix) {
        int m = chars.length;
        for (int i=0; i<m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i<m-1; i++) {
            // 公共后缀子串起始位置
            int j=i;
            // 公共后缀长度
            int k=0;
            while (j>=0 && chars[j]==chars[m-1-k]) {
                k++;
                suffix[k] = j;
                j--;
            }
            // 公共后缀子串也是模式串的前缀子串
            if (j==-1) {
                prefix[k] = true;
            }
        }
    }

}
