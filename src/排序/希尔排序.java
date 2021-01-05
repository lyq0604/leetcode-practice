package 排序;

import java.util.Arrays;

/**
 * @author lyq on 2020-12-23 下午9:00
 * @desc
 */
public class 希尔排序 {

    public static void main(String[] args) {
        int[] arr = {9,1,8,3,6,0,7,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int len = arr.length;
        // 步长递减
        for (int step=len/2;step>0;step/=2) {
            // 以指定的步长遍历数组中的所有元素
            for (int i=step;i<len;i++) {
                // 对组内的元素进行插入排序
                for (int j=i-step;j>=0;j-=step) {
                    if (arr[j] > arr[j+step]) {
                        int tmp = arr[j];
                        arr[j] = arr[j+step];
                        arr[j+step] = tmp;
                    }
                }
            }
        }
    }

}
