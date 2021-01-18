package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lyq on 2021-01-18 下午11:22
 * @desc 给定一个二叉树，在树的最后一行找到最左边的值。
 */
public class 二叉树左下角的值 {

    private static Integer maxLen;
    private static Integer leftVal;

    /**
     * 递归
     * @param root
     * @return
     */
    public static Integer findBottomLeftValue(TreeNode root) {
        if (root == null) return null;
        int len = 1;
        // '>'用于保证leftVal只记录导致深度加一的第一个元素的值
        if (len > maxLen) {
            maxLen = len;
            leftVal = root.val;
        }
        if (root.left != null) {
            len++;
            findBottomLeftValue(root.left);
            len--;
        }
        if (root.right != null) {
            len++;
            findBottomLeftValue(root.right);
            len--;
        }
        return leftVal;
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public static Integer findBottomLeftValue1(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Integer result = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                TreeNode poll = queue.poll();
                if (i == 0) result = poll.val;
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }
        return result;
    }

}
