package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lyq on 2021-01-17 下午11:25
 * @desc 最小深度：从根节点到最近一个 叶子节点 的路径上节点的数量
 */
public class 二叉树的最小深度 {

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
        // node2.setLeft(node4);
        // node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);

        System.out.println(minDepth1(node1));
    }

    /**
     * 递归法
     * @param node
     * @return
     */
    private static int minDepth(TreeNode node) {
        return 1 + Math.min(getDepth(node.left), getDepth(node.right));
    }

    private static int getDepth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        if (node.left == null && node.right != null) {
            return rightDepth + 1;
        } else if (node.right == null && node.left != null) {
            return leftDepth + 1;
        } else {
            return Math.min(leftDepth, rightDepth) + 1;
        }
    }

    /**
     * 迭代法
     * @param node
     * @return
     */
    private static int minDepth1(TreeNode node) {
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i=0;i<size;i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return depth+1;
    }
}
