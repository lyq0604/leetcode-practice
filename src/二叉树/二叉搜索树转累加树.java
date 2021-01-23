package 二叉树;

/**
 * @author lyq on 2021-01-23 下午10:15
 * @desc
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * 提醒一下，二叉搜索树满足下列约束条件：
 *      节点的左子树仅包含键 小于 节点键的节点。节点的右子树仅包含键 大于 节点键的节点。左右子树也必须是二叉搜索树。
 */
public class 二叉搜索树转累加树 {

    public int tmp = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        if (root.right != null) {
            convertBST(root.right);
        }
        root.val += tmp;
        tmp = root.val;
        if (root.left != null) {
            convertBST(root.left);
        }
        return root;
    }
}
