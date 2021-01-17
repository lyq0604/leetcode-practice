package 二叉树;

/**
 * @author lyq on 2021-01-17 下午10:48
 * @desc
 */
public class 判断二叉树是否对称 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        System.out.println(isMirror(node1));
    }

    public static boolean isMirror(TreeNode root) {
        return isSame(root, root);
    }

    public static boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        } else if (left.val == right.val) {
            return isSame(left.left, right.right) && isSame(left.right, right.left);
        } else  {
            return false;
        }
    }
}
