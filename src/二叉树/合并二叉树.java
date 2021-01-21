package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lyq on 2021-01-21 下午9:43
 * @desc 合并两颗二叉树，重合的节点值为两个节点值之和
 */
public class 合并二叉树 {

    /**
     * 递归
     * @param t1
     * @param t2
     * @return
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }

    /**
     * 迭代
     * @param t1
     * @param t2
     * @return
     */
    public static TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(t1);
        queue.add(t2);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            node1.val += node2.val;
            if (node1.left != null && node2.left != null) {
                queue.add(node1.left);
                queue.add(node2.left);
            }
            if (node1.right != null && node2.right != null) {
                queue.add(node1.right);
                queue.add(node2.right);
            }
            if (node1.left == null && node2.left != null) {
                node1.left = new TreeNode(node2.left.val);
            }
            if (node1.right == null && node2.right != null) {
                node1.right = new TreeNode(node2.right.val);
            }
        }
        return t1;
    }

}
