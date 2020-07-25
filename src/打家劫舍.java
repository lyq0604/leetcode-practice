/**
 * @author lyq on 2020-07-25 8:39 下午
 * @desc 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。  给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class 打家劫舍 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        int res = rob(arr);
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        nums[1] = Math.max(nums[0], nums[1]);
        for (int i=2;i<nums.length;i++) {
            nums[i] = Math.max(nums[i-2] + nums[i], nums[i-1]);
        }
        return nums[nums.length-1];
    }

    /**
     * 内存优化版
     */
    public static int rob1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int cur = 0;
        int pre = 0;
        for (int i=0;i<nums.length;i++) {
            int newCur = Math.max(cur+nums[i], pre);
            cur = pre;
            pre = newCur;
        }
        return Math.max(cur, pre);
    }

}
