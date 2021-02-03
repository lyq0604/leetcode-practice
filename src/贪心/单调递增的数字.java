package 贪心;

/**
 * @author lyq on 2021-02-03 下午8:40
 * @desc
 *   给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *  （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 */
public class 单调递增的数字 {

    public static void main(String[] args) {
        int res = monotoneIncreasingDigits(100);
        System.out.println(res);

    }

    public static int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        // 记录上一个变为9的元素位置
        int idx = chars.length-1;
        for (int i=chars.length-1;i>0;i--) {
            if (chars[i-1]>chars[i]) {
                chars[i] = '9';
                if (idx == -1) {
                    idx = i;
                } else {
                    if (idx >= i+1) {
                        while (idx>i) {
                            chars[idx--] = '9';
                        }
                    }
                }
                int val = Integer.valueOf(String.valueOf(chars[i-1]));
                chars[i-1] = String.valueOf(val-1).charAt(0);
            }
        }
        return Integer.valueOf(String.valueOf(chars));
    }

}
