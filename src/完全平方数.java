/**
 * @author lyq on 2020-11-12 10:54 下午
 * @desc 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 */
public class 完全平方数 {

    public static int numSquares(int n) {
        int[] arr = new int[n+1];
        arr[0] = 0;
        for (int i=1;i<=n;i++) {
            // 最坏情况由n个1相加
            arr[i] = i;
            for (int j=0;j*j<=i;j++) {
                // +1即j*j
                arr[i] = Math.min(arr[i], arr[i-j*j]+1);
            }
        }
        return arr[n];
    }

}
