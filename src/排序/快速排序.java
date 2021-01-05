package 排序;

import java.util.Arrays;

/**
 * @author lyq on 2020-12-23 下午9:17
 * @desc
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] arr = {4,1,8,3,6,0,7,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        quickSort(arr, left, right);
    }

    /**
     * @param arr
     * @param left 左边界
     * @param right 右边界
     */
    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int low = left;
        int high = right;
        int std = arr[low];
        while (low < high) {
            while (arr[high] >= std && low < high) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= std) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = std;
        quickSort(arr, left, low-1);
        quickSort(arr, low+1, right);
    }

}
