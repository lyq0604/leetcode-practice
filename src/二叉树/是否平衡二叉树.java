package 二叉树;

/**
 * @author lyq on 2021-01-18 下午8:46
 * @desc
 */
public class 是否平衡二叉树 {

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

        System.out.println(isBalance1(node1));
    }

    /**
     * 自定向下递归法：会出现多次计算同一颗子树高度的的情况
     * @param root
     * @return
     */
    public static boolean isBalance(TreeNode root) {
        if (root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return isBalance(root.left) && isBalance(root.right) && Math.abs(leftHeight-rightHeight) <= 1;
    }

    /**
     * 求以该节点为根节点的树高度
     * @param node
     * @return
     */
    private static int getHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    /**
     * 递归后序遍历
     * @param root
     * @return
     */
    private static boolean isBalance1(TreeNode root) {
        return getHeight1(root) >= 0;
    }

    private static int getHeight1(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        // 如果该节点的左右子树或以该节点为根节点的树不平衡，设置树的高度为-1
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
