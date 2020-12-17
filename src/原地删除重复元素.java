import java.util.Arrays;

/**
 * @author lyq on 2020-07-22 10:25 下午
 * @desc 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 */
public class 原地删除重复元素 {

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        System.out.println(solve3(arr));
    }

    /**
     * 非排序数组
     * @param arr
     * @param n
     * @return
     */
    public static int solve1(int[] arr, int n) {
        if (arr.length == 0) {
            return 0;
        }
        for (int i=0;i<arr.length;) {
            if (arr[i] != n) {
                i++;
            } else {
                arr[i] = arr[arr.length-1];
                arr[arr.length-1] = n;
                arr = Arrays.copyOfRange(arr, 0, arr.length-1);
            }
        }
        return arr.length;
    }

    public static int solve2(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        // 记录下一个非重复元素放置的下标
        int x = 1;
        for (int i=1;i<arr.length;) {
            if (arr[i] == arr[i-1]) {
                while (i < arr.length-1 && arr[i] == arr[i-1]) {
                    i++;
                }
                if (i == arr.length-1 && arr[i] == arr[i-1]) {
                    break;
                } else {
                    arr[x++] = arr[i++];
                }
            } else {
                arr[x++] = arr[i++];
            }
        }
        return Arrays.copyOfRange(arr, 0, x).length;
    }

    public static int solve3(int[] arr) {
        int n = 0;
        for (int i=1;i<arr.length;i++) {
            if (arr[i] == arr[n]) {
                continue;
            } else {
                arr[++n] = arr[i];
            }
        }
        return n+1;
    }

}
