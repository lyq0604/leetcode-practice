package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lyq on 2021-01-18 下午9:19
 * @desc 返回二叉树的根节点到所有叶子节点的路径
 */
public class 二叉树的所有路径 {

    private static List<List<TreeNode>> res = new LinkedList<>();

    public static void allPaths(TreeNode root) {
        if (root == null) return;

        List<TreeNode> list = new LinkedList<>();

        trace(root, list);

        System.out.println(res);
    }

    private static void trace(TreeNode root, List<TreeNode> list) {
        list.add(root);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (root.left != null) {
            trace(root.left, list);
            list.remove(list.size()-1);
        }
        if (root.right != null) {
            trace(root.right, list);
            list.remove(list.size()-1);
        }
    }

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
        node4.setLeft(node6);
        node4.setRight(node7);
        allPaths(node1);
    }

}
