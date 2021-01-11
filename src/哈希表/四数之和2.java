package 哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyq on 2021-01-11 下午9:18
 * @desc 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。
 */
public class 四数之和2 {

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<A.length;i++) {
            for (int j=0;j<B.length;j++) {
                int sum = A[i] + B[j];
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum)+1);
                } else {
                    map.put(sum, 1);
                }
            }
        }

        for (int i=0;i<C.length;i++) {
            for (int j=0;j<D.length;j++) {
                int sum = C[i] + D[j];
                if (map.containsKey(-sum)) {
                    res += map.get(-sum);
                }
            }
        }

        return res;
    }

}
