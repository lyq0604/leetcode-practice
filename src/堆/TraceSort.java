package 堆;

import java.util.Arrays;

/**
 * @author lyq on 2021-01-07 下午9:27
 * @desc 堆排序
 */
public class TraceSort {

    public static void main(String[] args) {
        int[] arr = {5,1,9,3,0,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        buildTrace(arr);
        int k = arr.length-1;
        while (k > 0) {
            // 将堆顶元素交换至最后位置
            int tmp = arr[0];
            arr[0] = arr[k];
            arr[k] = tmp;
            k--;
            // 重新构建堆
            heapify(arr, 0, k);
        }
    }

    /**
     * 构建堆: 从最后一个不是非叶子节点开始依次向前，将以该节点为堆顶的节点进行堆化
     * @param arr
     */
    public static void buildTrace(int[] arr) {
        for (int i=arr.length/2-1;i>=0;i--) {
            heapify(arr, i, arr.length-1);
        }
    }

    /**
     * 堆化操作(自上而下)
     * @param i 堆顶元素
     * @param n 最后一个节点位置
     */
    public static void heapify(int[] arr, int i, int n) {
        while (true) {
            int maxPos = i;
            if ((2*i+1)<=n && arr[(2*i+1)] > arr[maxPos]) {
                maxPos = 2*i+1;
            }
            if ((2*i+2)<=n && arr[(2*i+2)] > arr[maxPos]) {
                maxPos = 2*i+2;
            }
            if (maxPos == i) break;
            int tmp = arr[maxPos];
            arr[maxPos] = arr[i];
            arr[i] = tmp;
            i = maxPos;
        }
    }

}
