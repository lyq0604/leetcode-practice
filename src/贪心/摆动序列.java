package 贪心;

/**
 * @author lyq on 2021-01-31 下午8:55
 * @desc 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 */
public class 摆动序列 {

    public int wiggleMaxLength(int[] arr) {
        int res = 1;
        int curDiff = 0;
        int preDiff = 0;
        for (int i=1;i<arr.length;i++) {
            curDiff = arr[i] - arr[i-1];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                res++;
                preDiff = curDiff;
            }
        }
        return res;
    }

}
