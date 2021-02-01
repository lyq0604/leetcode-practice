package 贪心;

/**
 * @author lyq on 2021-02-01 下午7:14
 * @desc 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * 说明:
 *  如果题目有解，该答案即为唯一答案。
 *  输入数组均为非空数组，且长度相同。
 *  输入数组中的元素均为非负数。
 */
public class 加油站 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curRest = 0;
        int totalRest = 0;
        int start = 0;
        for (int i=0;i<gas.length;i++) {
            curRest += gas[i] - cost[i];
            totalRest += gas[i] - cost[i];
            // 如果当前剩余油量小于0,则起点不可能在 0 - i 之间；重置起点和当前剩余油量
            if (curRest < 0) {
                start = i+1;
                curRest = 0;
            }
        }
        // 如果一圈后的总油量小于0，表示转不完一圈
        if (totalRest < 0) return -1;
        return start;
    }

}
