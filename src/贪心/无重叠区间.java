package 贪心;

import java.util.Arrays;

/**
 * @author lyq on 2021-02-01 下午10:41
 * @desc 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意: 可以认为区间的终点总是大于它的起点。
 */
public class 无重叠区间 {

    public static void main(String[] args) {
        int[][] arr = {{1,2}, {2,3}, {3,4}, {1,3}};
        eraseOverlapIntervals(arr);
    }

    public static int eraseOverlapIntervals(int[][] arr) {
        if (arr.length == 0) return 0;
        // 按照截止位置升序
        Arrays.sort(arr, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        // 非重叠区间个数
        int num = 1;
        // 分割界
        int slice = arr[0][1];
        for (int i=1;i<arr.length;i++) {
            // 无重叠
            if (slice <= arr[i][0]) {
                slice = arr[i][1];
                num++;
            }
        }
        return arr.length - num;
    }

}
