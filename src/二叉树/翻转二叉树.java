package 二叉树;

/**
 * @author lyq on 2021-01-17 下午10:37
 * @desc
 */
public class 翻转二叉树 {

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
        reverse(node1);
    }

    public static void reverse(TreeNode root) {
        if (root != null) {
            reverseChild(root);
            reverseChild(root.left);
            reverseChild(root.right);
        }
    }

    public static void reverseChild(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

}
