/**
 * @author lyq on 2020-07-21 11:17 下午
 * @desc 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class 三次反转旋转数组 {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        solve2(a, 3);
    }

    /**
     * 额外空间法
     * @param arr
     * @param k
     * @return
     */
    public static int[] solve1(int[] arr, int k) {
        int[] res = new int[arr.length];
        for (int i=0;i<arr.length;i++) {
            res[(i+k)%arr.length] = arr[i];
        }
        return res;
    }

    /**
     * 原地翻转
     * @return
     */
    public static int[] solve2(int[] arr, int k) {
        // 整体翻转
        reverse(arr, 0, arr.length);
        // 0-k翻转
        reverse(arr, 0, k);
        // k-end翻转
        reverse(arr, k, arr.length);
        return arr;
    }

    public static void reverse(int[] arr, int start, int end) {
        for (int i=start;i<(end+start)/2;i++) {
            int temp = arr[i];
            arr[i] = arr[end+start-1-i];
            arr[end+start-1-i] = temp;
        }
    }

}
