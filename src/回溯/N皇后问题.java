package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyq on 2021-01-30 下午8:31
 * @desc
 */
public class N皇后问题 {

    private static List<int[][]> res = new ArrayList<>();

    public static List<int[][]> nqueue(int n) {
        int[][] arr = new int[n][n];
        trace(n, 0, arr);
        return res;
    }

    /**
     * @param n
     * @param row 行
     * @param arr
     */
    private static void trace(int n, int row, int[][] arr) {
        if (row == n) {
            res.add(arr);
            return;
        }
        for (int col=0;col<n;col++) {
            if (isValid(row, col, n, arr)) {
                arr[row][col] = 1;
                trace(n, row+1, arr);
                arr[row][col] = 0;
            }
        }
    }

    private static boolean isValid(int row, int col, int n, int[][] arr) {
        // 判断同列是否满足
        for (int i=0;i<row;i++) {
            if (arr[i][col] == 1) return false;
        }
        // 45度对角线
        for (int i=row-1,j=col-1;i>=0&&j>=0;i--,j--) {
            if (arr[i][j] == 1) return false;
        }
        // 135度
        for (int i=row-1,j=col+1;i>=0&&j<n;i--,j++) {
            if (arr[i][j] == 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        nqueue(3);
    }

}
