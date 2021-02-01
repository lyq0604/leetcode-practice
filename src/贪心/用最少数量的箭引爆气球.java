package 贪心;

import java.util.Arrays;

/**
 * @author lyq on 2021-02-01 下午9:58
 * @desc
 *      在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
 *      由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 *      一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。
 *      可以射出的弓箭的数量没有限制。弓箭一旦被射出之后，可以无限地前进。
 *      我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *      给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 */
public class 用最少数量的箭引爆气球 {


    public static void main(String[] args) {
        int[][] points = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        // 按照起始坐标升序
        Arrays.sort(points, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        int res = 0;
        // pre区间表示当前箭可以射穿的气球范围
        int[] pre = null;
        for (int i=0;i<points.length;i++) {
            int[] cur = points[i];
            if (pre == null) {
                pre = cur;
                res++;
            } else {
                if (cur[0]>=pre[0]&&cur[0]<=pre[1]) {
                    pre = new int[]{Math.max(pre[0], cur[0]), Math.min(pre[1], cur[1])};
                    continue;
                } else {
                    pre = cur;
                    res++;
                }
            }
        }
        return res;
    }

}
