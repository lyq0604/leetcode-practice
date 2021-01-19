package 二叉树;

import java.util.Stack;

/**
 * @author lyq on 2021-01-19 下午8:31
 * @desc 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 */
public class 路径总和 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node4.setLeft(node7);
        node4.setRight(node8);
        node3.setLeft(node5);
        node3.setRight(node6);
        node6.setRight(node9);
        System.out.println(pathSum(node1, 22));
    }

    /**
     * 递归法
     * @param root
     * @param target
     * @return
     */
    public static boolean pathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == target) {
            return true;
        }
        boolean res = false;
        if (root.left != null) {
            res = res || pathSum(root.left, target - root.val);
        }
        if (root.right != null) {
            res = res || pathSum(root.right, target - root.val);
        }
        return res;
    }

}
