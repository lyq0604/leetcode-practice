package 二叉树;

/**
 * @author lyq on 2021-01-22 下午9:43
 * @desc
 */
public class 二叉搜索树的最近公共祖先 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if (left != null) {
                return left;
            }
        }
        if (root.val < p.val && root.val < q.val) {
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (right != null) {
                return right;
            }
        }
        // 如果p,q的值分布于root的两侧，则直接返回该节点
        return root;
    }

}
