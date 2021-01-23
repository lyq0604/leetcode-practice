package 二叉树;

/**
 * @author lyq on 2021-01-22 下午10:18
 * @desc
 */
public class 删除二叉搜索树中的节点 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        TreeNode node = deleteNode(node1, 3);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                int nextVal = searchNextVal(root.right);
                root.val = nextVal;
                root.right = deleteNode(root.right, nextVal);
            }
        }
        return root;
    }

    public static int searchNextVal(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

}
