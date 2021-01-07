package 数组;

/**
 * @author lyq on 2021-01-06 下午9:01
 * @desc 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *  你可以假设数组中无重复元素。
 */
public class 搜索插入位置 {

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int target = 7;
        System.out.println(searchPos(arr, target));
    }

    public static int searchPos(int[] arr, int target) {
        if (arr.length == 0) return 0;
        int low = 0;
        int high = arr.length-1;
        // 插入最前位置
        if (arr[0] > target) {
            return 0;
        // 插入最后位置
        } else if (arr[high] < target) {
            return high + 1;
        } else {
            while (low <= high) {
                int mid = low + (high-low)/2;
                if (target < arr[mid]) {
                    high = mid - 1;
                } else if (target > arr[mid]) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
            return low+1;
        }
    }

}
