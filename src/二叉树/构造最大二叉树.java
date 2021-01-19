package 二叉树;

/**
 * @author lyq on 2021-01-19 下午11:15
 * @desc 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树
 * 定义如下：
 *  二叉树的根是数组 nums 中的最大元素。
 *  左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 *  右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 */
public class 构造最大二叉树 {

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        int maxIdx = 0;
        for (int i = 1; i<len; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIdx]);
        // 最大值左边的数
        int[] left = new int[maxIdx];
        System.arraycopy(nums, 0, left, 0, maxIdx);
        // 最大值右边的数
        int[] right = new int[len-1-maxIdx];
        System.arraycopy(nums, maxIdx+1, right, 0, len-1-maxIdx);
        root.left = constructMaximumBinaryTree(left);
        root.right = constructMaximumBinaryTree(right);
        return root;
    }

}
