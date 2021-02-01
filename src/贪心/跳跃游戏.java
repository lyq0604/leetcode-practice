package 贪心;

/**
 * @author lyq on 2021-01-31 下午9:55
 * @desc 给定一个非负整数数组，你最初位于数组的第一个位置。  数组中的每个元素代表你在该位置可以跳跃的最大长度。  判断你是否能够到达最后一个位置。
 */
public class 跳跃游戏 {

    public static void main(String[] args) {

    }

    public boolean canJump(int[] arr) {
        if (arr.length == 1) return true;
        // 当前可跳范围
        int max = 0;
        for (int i=0;i<=max;i++) {
            max = Math.max(arr[i]+i, max);
            if (max >= arr.length-1) {
                return true;
            }
        }
        return false;
    }

}
