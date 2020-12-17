/**
 * @author lyq on 2020-07-27 11:35 下午
 * @desc 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class 移动0 {

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
    }

    public static void moveZeroes(int[] nums) {
        // int zeroNum = 0;
        // for (int i=0;i<nums.length;i++) {
        //     if (nums[i] == 0) {
        //         zeroNum++;
        //     } else {
        //         nums[i-zeroNum] = nums[i];
        //     }
        // }
        // for (int i=0;i<zeroNum;i++) {
        //     nums[nums.length-1-i] = 0;
        // }
        int len = nums.length;
        // 记录0的个数
        int n = 0;
        for (int i=0;i<len;i++) {
            if (nums[i] == 0) {
                n++;
            }
            if (i == 0) continue;
            if (n > 0 && nums[i] != 0) {
                nums[i-n] = nums[i];
            }
        }
        if (n > 0) {
            for (int i=1;i<=n;i++) {
                nums[len-i] = 0;
            }
        }
    }

}
