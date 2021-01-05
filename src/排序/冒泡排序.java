package 排序;

import java.util.Arrays;

/**
 * @author lyq on 2020-12-21 下午8:49
 * @desc
 */
public class 冒泡排序 {

    public static void main(String[] args) {
        int[] arr = {5,1,9,3,0,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int len = arr.length;
        for (int i=0; i<len-1; i++) {
            boolean flag = true;
            for (int j=0; j<len-i-1; j++) {
                if (arr[j]>arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

}
