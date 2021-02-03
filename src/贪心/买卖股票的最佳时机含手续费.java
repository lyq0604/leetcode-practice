package 贪心;

/**
 * @author lyq on 2021-02-03 下午9:09
 * @desc 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *      你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。  返回获得利润的最大值。
 *      注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 */
public class 买卖股票的最佳时机含手续费 {

    public static void main(String[] args) {
        int[] prices = {1, 3, 7, 5, 10, 3};
        int fee = 3;
        System.out.println(maxProfit(prices, fee));
    }

    /**
     * 买入价格不变的条件下，如果 (当前卖出价格-手续费) > (上次卖出价格-手续费), 则可以不进行上次卖出从而获取该买入价格下的最大利润
     * @param prices
     * @param fee
     * @return
     */
    public static int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) return 0;
        int res = 0;
        int buy = prices[0];
        for (int i=1;i<prices.length;i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            }
            if (prices[i] - buy - fee > 0) {
                res += prices[i] - buy - fee;
                // 把卖出当天的价格同时当作买入价格，由于卖出时已减过一次手续费，因此不是 buy = prices[i];
                buy = prices[i] - fee;
            }
        }
        return res;
    }


}
