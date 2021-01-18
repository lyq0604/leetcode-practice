package 二叉树;

import java.util.Stack;

/**
 * @author lyq on 2021-01-18 下午10:33
 * @desc
 */
public class 左叶子之和 {

    /**
     * 递归
     * @param root
     * @return
     */
    public static int leftLeafSum(TreeNode root) {
        if (root == null) return 0;
        int cur = 0;
        int left = leftLeafSum(root.left);
        int right = leftLeafSum(root.right);
        if (root.left != null && root.left.left == null && root.left.right == null) {
            cur = root.left.val;
        }
        return cur + left + right;
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public static int leftLeafSum1(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top.left != null && top.left.left == null && top.left.right == null) {
                sum += root.left.val;
            }
            if (top.left != null) {
                stack.add(top.left);
            }
            if (top.right != null) {
                stack.add(top.right);
            }
        }
        return sum;
    }
}
