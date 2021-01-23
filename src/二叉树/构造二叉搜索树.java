package 二叉树;

/**
 * @author lyq on 2021-01-23 下午10:01
 * @desc 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class 构造二叉搜索树 {

    public static TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        int mid = len/2;
        TreeNode root = new TreeNode(nums[mid]);
        if (len == 1) {
            return root;
        }
        root.left = generateSubTree(nums, 0, mid-1);
        root.right = generateSubTree(nums, mid+1, len-1);
        return root;
    }

    private static TreeNode generateSubTree(int[] nums, int start, int end) {
        if (end<start) return null;
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if (end-start==0) {
            return root;
        }
        root.left = generateSubTree(nums, start, mid-1);
        root.right = generateSubTree(nums, mid+1, end);
        return root;
    }


}
