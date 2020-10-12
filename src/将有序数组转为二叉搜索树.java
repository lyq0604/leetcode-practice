/**
 * @author lyq on 2020-10-12 9:15 下午
 * @desc 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 */
public class 将有序数组转为二叉搜索树 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

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

    /**
     * 生成
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static TreeNode generateSubTree(int[] nums, int left, int right) {
        if (left == right) {
            return new TreeNode(nums[left]);
        } else if (right < left) {
            return null;
        } else {
            int mid = (left + right) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = generateSubTree(nums, left, mid-1);
            node.right = generateSubTree(nums, mid+1, right);
            return node;
        }
    }

    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};
        TreeNode node = sortedArrayToBST(arr);
    }

}
