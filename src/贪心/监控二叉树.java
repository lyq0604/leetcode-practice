package 贪心;

/**
 * @author lyq on 2021-02-03 下午10:20
 * @desc 给定一个二叉树，我们在树的节点上安装摄像头。  节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。  计算监控树的所有节点所需的最小摄像头数量。
 */
public class 监控二叉树 {

    private static int res = 0;

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int minCameraCover(TreeNode root) {
        if (trace(root) == 0) {
            res++;
        }
        return res;
    }

    /**
     * 原则：
     *      叶节点不放置摄像头;
     *      0: 无覆盖, 1: 有摄像头, 2: 有覆盖
     * @param cur
     * @return
     */
    private static int trace(TreeNode cur) {
        // 空节点为被覆盖状态
        if (cur == null) {
            return 2;
        }
        int left = trace(cur.left);
        int right = trace(cur.right);
        // 左右节点均为覆盖,则该节点为未覆盖
        if (left == 2 && right == 2) {
            return 0;
        // 如果任一子节点未覆盖,则该节点应有摄像头
        } else if (left == 0 || right == 0) {
            res++;
            return 1;
        // 左右子节点存在摄像头
        } else {
            return 2;
        }
    }


}
