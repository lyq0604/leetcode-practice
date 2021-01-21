package 二叉树;

import java.util.Stack;

/**
 * @author lyq on 2021-01-21 下午10:09
 * @desc 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class 验证二叉搜索树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST2(root));
    }

    private static Integer max = Integer.MIN_VALUE;

    /**
     * 递归法
     * @param root
     * @return
     */
    public static boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST1(root.left);
        if (root.val > max) {
            max = root.val;
        } else {
            return false;
        }
        boolean right = isValidBST1(root.right);
        return left && right;
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public static boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Long pre = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode top = stack.pop();
                if (top.val < pre) return false;
                pre = Long.valueOf(top.val);
                if (top.right != null) {
                    root = top.right;
                }
            }
        }
        return true;
    }

}
