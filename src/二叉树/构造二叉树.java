package 二叉树;

/**
 * @author lyq on 2021-01-19 下午9:22
 * @desc
 */
public class 构造二叉树 {

    public static void main(String[] args) {
        int[] in = {9,3,15,20,7};
        int[] pre = {3,9,20,15,7};
        int[] after = {9,15,7,20,3};
        TreeNode node = buildTree2(pre, in);
    }

    /**
     * 中序 + 后序
     * @param inorder 中序
     * @param postorder 后序
     * @return
     */
    public static TreeNode buildTree1(int[] inorder, int[] postorder) {
        int len = postorder.length;
        if (len == 0) return null;
        // 后序遍历的最后一个节点是中间节点，即当前节点
        int midVal = postorder[len-1];
        TreeNode root = new TreeNode(midVal);
        // 寻找该节点在中序遍历数组中的位置
        int idx;
        for (idx=0;idx<inorder.length;idx++) {
            if (inorder[idx] == midVal) break;
        }
        // 中序遍历左子树
        int[] midLeft = new int[idx];
        System.arraycopy(inorder, 0, midLeft, 0, idx);
        // 中序遍历右子树
        int[] midRight = new int[len-idx-1];
        System.arraycopy(inorder, idx+1, midRight, 0, len-idx-1);
        // 后序遍历左子树
        int[] afterLeft = new int[idx];
        System.arraycopy(postorder, 0, afterLeft, 0, idx);
        // 后序遍历右子树
        int[] afterRight = new int[len-idx-1];
        System.arraycopy(postorder, idx, afterRight, 0, len-idx-1);
        root.left = buildTree1(midLeft, afterLeft);
        root.right = buildTree1(midRight, afterRight);
        return root;
    }

    /**
     * 前序 + 中序
     * @param preorder 前序
     * @param inorder 中序
     * @return
     */
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        int len = inorder.length;
        if (len == 0) return null;
        // 前序遍历的第一个节点是中间节点，即当前节点
        int midVal = preorder[0];
        TreeNode root = new TreeNode(midVal);
        // 寻找该节点在中序遍历数组中的位置
        int idx;
        for (idx=0;idx<len;idx++) {
            if (inorder[idx] == midVal) break;
        }
        // 中序遍历左子树
        int[] midLeft = new int[idx];
        System.arraycopy(inorder, 0, midLeft, 0, idx);
        // 中序遍历右子树
        int[] midRight = new int[len-idx-1];
        System.arraycopy(inorder, idx+1, midRight, 0, len-idx-1);
        // 前序遍历左子树
        int[] preLeft = new int[idx];
        System.arraycopy(preorder, 1, preLeft, 0, idx);
        // 前序遍历右子树
        int[] preRight = new int[len-idx-1];
        System.arraycopy(preorder, idx+1, preRight, 0, len-idx-1);
        root.left = buildTree2(preLeft, midLeft);
        root.right = buildTree2(preRight, midRight);
        return root;
    }


    /** 前后+后序无法构造一个二叉树，因为无法确定拆分的位置 **/
}
