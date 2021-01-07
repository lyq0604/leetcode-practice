package 数组;

import java.util.Arrays;

/**
 * @author lyq on 2021-01-06 下午10:11
 * @desc 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例: 输入: 3  输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 */
public class 螺旋矩阵 {

    public static void main(String[] args) {
        int n = 3;
        int[][] arr = draw(n);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 坚持在画每条线是左闭右开
     * @param n
     * @return
     */
    public static int[][] draw(int n) {
        int[][] arr = new int[n][n];
        // 每圈的起始位置
        int x = 0, y = 0;
        // 需要画的圈数：n为奇数时，正中值需单独赋值。
        int loop = n/2;
        // 矩阵正中位置坐标
        int mid = n/2;
        // 用于为矩阵赋值的数
        int count = 1;
        // 每一圈循环，需要控制每一条边遍历的长度
        int offset = 1;
        // row, col
        int row, col;

        while (loop>0) {
            row = x;
            col = y;
            // 上边：左 -> 右
            for (;col<x+n-offset;col++) {
                arr[row][col] = count++;
            }
            // 后边：上 -> 下
            for (;row<y+n-offset;row++) {
                arr[row][col] = count++;
            }
            // 下边：右 -> 左
            for (;col>x;col--) {
                arr[row][col] = count++;
            }
            // 前面：下 -> 上
            for (;row>y;row--) {
                arr[row][col] = count++;
            }
            // 画下一圈时起点位置变化
            x++;
            y++;
            // 限定范围变化
            offset+=2;

            loop--;
        }

        if (n%2 == 1) {
            arr[mid][mid] = count;
        }

        return arr;
    }

}
