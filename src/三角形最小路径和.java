import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lyq on 2020-07-25 7:24 下午
 * @desc 给定一个三角形，找出自顶向下的最小路径和,每一步只能移动到下一行中相邻的结点上。
 */
public class 三角形最小路径和 {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6 , 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));
        int res = minPath(list);
    }

    /**
     * 该方法缺陷是内存使用过大，优化思路是不要建dp数组，直接使用list记录各个位置上的值
     * @param list
     * @return
     */
    public static int minPath(List<List<Integer>> list) {
        int res = 0;
        int size = list.size();
        if (size == 0){
            return res;
        }
        int[][] dp = new int[size][size];
        dp[0][0] = list.get(0).get(0);
        if (size == 1) {
            return dp[0][0];
        }
        dp[1][0] = list.get(1).get(0) + dp[0][0];
        dp[1][1] = list.get(1).get(1) + dp[0][0];
        if (size == 2) {
            return Math.min(dp[1][0], dp[1][1]);
        }
        for (int i=2;i<size;i++) {
            List<Integer> subList = list.get(i);
            int subSize = subList.size();
            for (int j=0;j<subSize;j++) {
                if (j==0) {
                    dp[i][j] = dp[i-1][j] + subList.get(j);
                } else if (j == subSize-1) {
                    dp[i][j] = dp[i-1][j-1] + subList.get(j);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + subList.get(j);
                }
            }
        }
        int[] arr = dp[size - 1];
        Arrays.sort(arr);
        return arr[0];
    }

}
