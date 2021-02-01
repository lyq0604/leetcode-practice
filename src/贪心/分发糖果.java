package 贪心;

/**
 * @author lyq on 2021-02-01 下午8:02
 * @desc 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *  你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *      每个孩子至少分配到 1 个糖果。
 *      相邻的孩子中，评分高的孩子必须获得更多的糖果。
 *  那么这样下来，老师至少需要准备多少颗糖果呢？
 */
public class 分发糖果 {

    public static void main(String[] args) {
        int[] arr = {1,0,2};
        int res = candy(arr);
        System.out.println(res);
    }

    /**
     * 两次贪心，分别求得满足单向规则时各位置上的最小值;然后取各位置上较大的值满足双向规则
     * @param arr
     * @return
     */
    public static int candy(int[] arr) {
        int len = arr.length;
        int[] candy = new int[len];
        // 左贪心：当前元素 > 左元素 时，糖果+1
        for (int i=0;i<len;i++) {
            if (i > 0 && arr[i] > arr[i-1]) {
                candy[i] = candy[i-1] + 1;
            } else {
                candy[i] = 1;
            }
        }
        // 右贪心：当前元素 > 右元素 时，糖果+1, 当前元素的糖果值等于同时满足左右规则的最大值。
        int right = 0;
        for (int i=len-1;i>=0;i--) {
            if (i < len-1 && arr[i] > arr[i+1]) {
                right++;
            } else {
                right = 1;
            }
            candy[i] = Math.max(candy[i], right);
        }
        int sum = 0;
        for (int i=0;i<candy.length;i++) {
            sum += candy[i];
        }
        return sum;
    }

}
