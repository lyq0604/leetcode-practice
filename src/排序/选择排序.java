package 排序;

import java.util.Arrays;

/**
 * @author lyq on 2020-12-21 下午9:09
 * @desc
 */
public class 选择排序 {

    public static void main(String[] args) {
        int[] arr = {5,1,9,3,0,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int len = arr.length;
        for (int i=0;i<len-1;i++) {
            int minIndex = i;
            for (int j=i+1;j<len;j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = tmp;
            }
        }
    }

}
