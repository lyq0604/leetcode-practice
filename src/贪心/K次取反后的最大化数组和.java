package 贪心;

import java.util.Arrays;

/**
 * @author lyq on 2021-01-31 下午11:19
 * @desc 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 * 以这种方式修改数组后，返回数组可能的最大和。
 */
public class K次取反后的最大化数组和 {

    public int largestSumAfterKNegations(int[] arr, int k) {
        Arrays.sort(arr);
        for (int i=0;i<arr.length;i++) {
            if (k == 0) break;
            if (arr[i] < 0) {
                arr[i] = -arr[i];
                k--;
            } else if (arr[i] == 0) {
                break;
            } else {
                k = k%2;
                if (k == 0) {
                    break;
                } else {
                    if (i == 0) {
                        arr[i] = -arr[i];
                    } else {
                        if (arr[i] > arr[i-1]) {
                            arr[i-1] = -arr[i-1];
                        } else {
                            arr[i] = -arr[i];
                        }
                    }
                    break;
                }
            }
        }
        int sum = 0;
        for (int i=0;i<arr.length;i++) {
            sum+=arr[i];
        }
        return sum;
    }

}
