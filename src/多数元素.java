/**
 * @author lyq on 2020-07-27 10:38 下午
 * @desc 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
*  你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class 多数元素 {

    /**
     * 解法一：哈希表法;
     * 解法二：排序法;
     */

    /**
     * 分治算法: 将数组分成左右两部分，分别求出左半部分的众数 a1 以及右半部分的众数 a2，随后在 a1 和 a2 中选出正确的众数。
     * @return
     */
    public static int majorityElement(int[] nums) {
        int res = majorityElementRec(nums, 0, nums.length-1);
        return res;
    }

    // 在指定范围内获取众数
    private static int majorityElementRec(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int mid = (high-low)/2 + low;
        int left = majorityElementRec(nums, low, mid);
        int right = majorityElementRec(nums, mid+1, high);

        if (left == right) {
            return left;
        }

        int leftNum = countInRange(nums, left, low, mid);
        int rightNum = countInRange(nums, right, mid+1, high);
        return leftNum > rightNum ? left : right;
    }

    // 获取指定范围内众数的出现次数
    private static int countInRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    /**
     * 投票法：
     *  如果候选人不是maj 则 maj,会和其他非候选人一起反对 会反对候选人,所以候选人一定会下台(maj==0时发生换届选举)
     *  如果候选人是maj , 则maj 会支持自己，其他候选人会反对，同样因为maj 票数超过一半，所以maj 一定会成功当选
     * @param nums
     * @return
     */
    public static int vote(int[] nums) {
        Integer candidate = null;
        int count = 0;
        for (Integer i : nums) {
            // 如果票数为0发生换届
            if (count == 0) {
                candidate = i;
            }
            if (candidate == i) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return candidate;
    }

}
