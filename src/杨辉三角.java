import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *    [1],
 *   [1,1],
 *  [1,2,1],
 * [1,3,3,1],
 *[1,4,6,4,1]
 *
 *
 * @author lyq
 * @date 2020/7/12 20:26
 */
public class 杨辉三角 {

    public static void main(String[] args) {
        List<List<Integer>> res = generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        if (numRows == 0) return res;
        res.add(Arrays.asList(1));
        if (numRows == 1) {
            return res;
        }
        for (int i=2;i<=numRows;i++) {
            Integer[] arr = new Integer[i];
            // 首尾赋值为1
            arr[0] = 1;
            arr[i-1] = 1;
            List<Integer> lastArr = res.get(i-2);
            for (int index=1;index<arr.length-1;index++) {
                arr[index] = lastArr.get(index) + lastArr.get(index-1);
            }
            res.add(Arrays.asList(arr));
        }
        return res;
    }

}
