package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lyq on 2020-07-13 10:19 下午
 * @desc 给定两个数组，编写一个函数来计算它们的交集。
 */
public class 两个数组的交集 {

    public static void main(String[] args) {
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        int[] res = intersect(nums1, nums2);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] emptyArr = new int[0];
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 || len2 == 0) {
            return emptyArr;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (nums1[0] > nums2[len2-1] || nums2[0] > nums1[len1-1]) {
            return emptyArr;
        }
        int i=0;
        int j=0;
        List<Integer> res = new ArrayList<>();
        while (i<len1 && j<len2) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        if (res.size() == 0) {
            return emptyArr;
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

}
