package 二叉树;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lyq on 2021-01-21 下午11:10
 * @desc 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 *      结点左子树中所含结点的值小于等于当前结点的值
 *      结点右子树中所含结点的值大于等于当前结点的值
 *      左子树和右子树都是二叉搜索树
 */
public class 二叉搜索树的众数 {

    // 方法一：遍历二叉树构造map
    // 方法二：前序遍历构造数组，双指针法统计众数

    private static Set<Integer> res = new HashSet<>();

    private static int maxCount = 0;
    private static int count = 1;
    private static TreeNode pre = null;

    // 方法三：设置pre节点，用于中序遍历中的前一个节点的值。
    public static Set<Integer> findMode(TreeNode root) {
        if (root == null) return null;
        // 左子节点处理
        findMode(root.left);
        if (pre == null) {
            pre = root;
            res.add(root.val);
            maxCount++;
            root = root.left;
        } else if (root.val == pre.val) {
            count++;
            if (count == maxCount) {
                res.add(root.val);
            } else if (count > maxCount) {
                res.clear();
                res.add(root.val);
            }
        } else {
            count = 1;
        }
        pre = root;
        root = root.left;
        // 右子节点处理
        findMode(root.right);
        return res;
    }

}
