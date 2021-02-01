package 贪心;

/**
 * @author lyq on 2021-01-31 下午10:18
 * @desc
 *  给定一个非负整数数组，你最初位于数组的第一个位置。
 *  数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *  你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 */
public class 跳跃游戏II {

    /**
     * 难点：只有到达当前步数覆盖范围最大值且未到达终点时步数才需增加;步数增加时意味着覆盖范围需要更新。
     * @param arr
     * @return
     */
    public int jump(int[] arr) {
        // 当前覆盖范围
        int curMax = 0;
        // 下一步覆盖范围
        int nextMax = 0;
        int step = 0;
        for (int i=0;i<arr.length;i++) {
            nextMax = Math.max(arr[i]+i, nextMax);
            if (i == curMax) {
                // 如果到达当前覆盖范围且未终点，需步数+1,更新覆盖范围
                if (curMax < arr.length-1) {
                    step++;
                    curMax = nextMax;
                    if (curMax >= arr.length-1) {
                        break;
                    }
                // 到达终点
                } else {
                    break;
                }
            }
        }
        return step;
    }

}
