package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lyq on 2021-01-17 下午11:03
 * @desc
 */
public class 二叉树的最大深度 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        // node5.setLeft(node8);
        System.out.println(depth1(node1));
    }

    /**
     * 递归法
     * @param root
     * @return
     */
    public static int depth(TreeNode root) {
        return Math.max(getSubTreeDepth(root.left), getSubTreeDepth(root.right)) + 1;
    }

    private static int getSubTreeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(getSubTreeDepth(node.left), getSubTreeDepth(node.right)) + 1;
        }
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public static int depth1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i=0;i<size;i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return depth;
    }

}
