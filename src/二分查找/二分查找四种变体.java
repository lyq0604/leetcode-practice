package 二分查找;

/**
 * @author lyq on 2021-01-03 下午8:33
 * @desc
 */
public class 二分查找四种变体 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 8, 8, 8, 11, 13};
        System.out.println(binarySearch2(arr, 8));
    }

    /**
     * 查找第一个等于给定值的元素下标
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearch1(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid-1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素下标
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearch2(int[] arr, int value) {
        int low = 0;
        int len = arr.length;
        int high = len - 1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (arr[mid] >= value) {
                if (mid == 0 || arr[mid-1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearch3(int[] arr, int value) {
        int low = 0;
        int len = arr.length;
        int high = len - 1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == len - 1 || arr[mid+1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearch4(int[] arr, int value) {
        int low = 0;
        int len = arr.length;
        int high = len - 1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (arr[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == len - 1 || arr[mid-1] > value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

}
