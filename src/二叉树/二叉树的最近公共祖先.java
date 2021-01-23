package 二叉树;

/**
 * @author lyq on 2021-01-21 下午11:42
 * @desc 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class 二叉树的最近公共祖先 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点等于p,q则返回该节点
        if (root == null || root == p || root == q) {
            return root;
        }
        // 从root的左子树中查找p,q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 从root的右子树中查询p,q
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }

}
