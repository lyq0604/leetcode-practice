package 排序;

import java.util.Arrays;

/**
 * @author lyq on 2020-12-21 下午9:29
 * @desc
 */
public class 插入排序 {

    public static void main(String[] args) {
        int[] arr = {5,1,9,3,0,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int len = arr.length;
        for (int i=1;i<len;i++) {
            if (arr[i-1] > arr[i]) {
                int num = arr[i];
                int j;
                for (j=i-1;j>=0 && arr[j]>num;j--) {
                    arr[j+1] = arr[j];
                }
                arr[j+1] = num;
            }
        }
    }

}
