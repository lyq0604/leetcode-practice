package 数组;

import java.util.Arrays;

/**
 * @author lyq on 2021-01-06 下午9:26
 * @desc 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并「原地」修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class 移除元素 {

    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        System.out.println(removeItem(arr, 2));
        System.out.println(Arrays.toString(arr));
    }

    public static int removeItem(int[] arr, int val) {
        int len = arr.length;
        if (len == 0) return 0;
        // 记录数组中直为val的元素个数
        int n = 0;
        for (int i=0;i<len;i++) {
            if (arr[i] == val) {
                n++;
            } else {
                arr[i-n] = arr[i];
            }
        }
        return len-n;
    }

    public static int removeItem1(int[] arr, int val) {
        int len = arr.length;
        if (len == 0) return 0;
        int slow = 0;
        for (int fast=0;fast<len;fast++) {
            if (arr[fast] != val) {
                arr[slow++] = arr[fast];
            }
        }
        return slow;
    }

}
