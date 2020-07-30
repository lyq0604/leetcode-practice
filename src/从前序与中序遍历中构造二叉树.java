import java.util.HashMap;
import java.util.Map;

/**
 * @author lyq on 2020-07-15 9:52 下午
 * @desc 根据一棵树的前序遍历与中序遍历构造二叉树。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class 从前序与中序遍历中构造二叉树 {

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder.length != inOrder.length) {
            throw new RuntimeException("数组长度异常");
        }
        Map<Integer, Integer> map = new HashMap<>(inOrder.length);
        for (int i=0;i<inOrder.length;i++) {
            map.put(inOrder[i], i);
        }
        return buildChildTree(preOrder,0, preOrder.length-1, 0, inOrder.length-1, map);
    }

    /**
     * （1）前序遍历序列的第一个元素是根节点
     * （2）无论是前序遍历还是中序遍历，根节点的左右子树元素个数一定。
     * @param preOrder
     * @param pre_left 前序遍历左边界
     * @param pre_right 前序遍历右边界
     * @param in_left 中序遍历左边界
     * @param in_right 中序遍历右边界
     * @param map
     * @return
     */
    private TreeNode buildChildTree(int[] preOrder, int pre_left, int pre_right, int in_left, int in_right, Map<Integer, Integer> map) {
        if (pre_left > pre_right || in_left > in_right) {
            return null;
        }
        // 创建根节点
        TreeNode root = new TreeNode(preOrder[pre_left]);
        // 根节点在中序遍历数组中的位置
        Integer rootIndex = map.get(preOrder[pre_left]);
        root.left = buildChildTree(preOrder, pre_left + 1, rootIndex + pre_left - in_left, in_left, rootIndex - 1, map);
        root.right = buildChildTree(preOrder, rootIndex + pre_left - in_left + 1, pre_right, rootIndex + 1, in_right, map);
        return root;
    }

}
