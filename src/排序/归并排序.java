package 排序;

import java.util.Arrays;

/**
 * @author lyq on 2020-12-23 下午9:43
 * @desc
 */
public class 归并排序 {

    public static void main(String[] args) {
        int[] arr = {9,1,8,3,6,0,7,2};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left+right)/2;
            sort(arr, left, mid);
            sort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    /**
     * 两无序数组合并为有序数组
     * @param arr 原数组
     * @param start 开始位置
     * @param mid 两数组分割位置
     * @param end 截止位置
     */
    public static void merge(int[] arr, int start, int mid, int end) {
        // 临时数组存放合并结果
        int[] tmp = new int[end-start+1];
        // 数组1指针
        int idx1 = start;
        // 数组2指针
        int idx2 = mid+1;
        // 临时数组指针
        int idx = 0;
        while (idx1 <= mid && idx2 <= end) {
            if (arr[idx1] < arr[idx2]) {
                tmp[idx++] = arr[idx1++];
            } else {
                tmp[idx++] = arr[idx2++];
            }
        }
        // 数组1剩余元素
        while (idx1 <= mid) {
            tmp[idx++] = arr[idx1++];
        }
        // 数组2剩余元素
        while (idx2 <= end) {
            tmp[idx++] = arr[idx2++];
        }
        // 将合并后的临时数组重新赋值至原数组中
        for (int i=0;i<tmp.length;i++) {
            arr[start++] = tmp[i];
        }
    }

}
