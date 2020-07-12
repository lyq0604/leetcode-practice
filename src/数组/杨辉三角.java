package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lyq
 * @date 2020/7/12 20:26
 */
public class 杨辉三角 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        res.add(Arrays.asList(1));
        if (numRows == 1) {
            return res;
        }
        for (int i=2;i<=numRows;i++) {
            int[] arr = new int[i];
            // 首尾赋值为1
            arr[0] = 1;
            arr[i-1] = 1;

        }
        return res;
    }

}
