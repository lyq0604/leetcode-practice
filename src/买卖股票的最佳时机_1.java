/**
 * @author lyq on 2020-07-15 9:14 下午
 * @desc 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 */
public class 买卖股票的最佳时机_1 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i=0;i<prices.length;i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                res = Math.max(res, prices[i] - min);
            }
        }
        return res;
    }

}
