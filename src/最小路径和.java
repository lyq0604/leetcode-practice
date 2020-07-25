/**
 * @author lyq on 2020-07-25 8:15 下午
 * @desc 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 */
public class 最小路径和 {

    public static void main(String[] args) {
        int[][] arr = {
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };
        int res = minPathSum(arr);
    }

    public static int minPathSum(int[][] grid) {
        // 行
        int m = grid.length;
        // 列
        int n = grid[0].length;
        // 初始化第一列
        for (int i=1;i<m;i++) {
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }
        // 初始化第一行
        for (int i=1;i<n;i++) {
            grid[0][i] = grid[0][i-1] + grid[0][i];
        }
        // 初始化其他值：该值+上 与 该值+左 中较小的值
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                grid[i][j] = Math.min(grid[i][j] + grid[i-1][j], grid[i][j] + grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }

}
