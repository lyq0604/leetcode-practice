/**
 * @author lyq on 2020-07-28 10:02 下午
 * @desc 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。   
 * 说明:  初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */
public class 合并两个有序数组 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
    }

    /**
     * 解法：
     * (1) 合并后排序
     * (2) 额外空间 + 双指针
     * (3) 双指针从后往前法: 先放大的数至尾部
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m-1;
        int i2 = n-1;
        // 追踪添加元素的位置
        int p = m + n - 1;
        while (i1 >=0 && i2 >= 0) {
            nums1[p--] = nums1[i1] > nums2[i2] ? nums1[i1--] : nums2[i2--];
        }
        // 防止nums2有剩余元素
        System.arraycopy(nums2, 0, nums1, 0, i2+1 );
    }

}
