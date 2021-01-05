package 二叉树;

import java.util.Stack;

/**
 * @author lyq on 2021-01-05 下午10:02
 * @desc 迭代式 前中后序遍历
 */
public class 前中后序遍历 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);

        // preSearch(node1);
        // midSearch(node1);
        postSearch(node1);
    }

    /**
     * 前序遍历
     * @param root
     */
    private static void preSearch(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            System.out.println(top.val);
            if (top.right != null) {
                stack.add(top.right);
            }
            if (top.left != null) {
                stack.add(top.left);
            }
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    private static void midSearch(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode top = stack.pop();
                System.out.println(top.val);
                root = top.right;
            }
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    private static void postSearch(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        // 用于记录上一遍历节点
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == pre) {
                System.out.println(root.val);
                pre = root;
                root = null;
            } else {
                stack.add(root);
                root = root.right;
            }
        }
    }

}
