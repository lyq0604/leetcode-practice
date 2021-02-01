package 贪心;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author lyq on 2021-02-01 下午9:21
 * @desc
 *  假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 *  每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 *  请你重新构造并返回输入数组 people 所表示的队列。
 *  返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 */
public class 重建队列 {

    public static void main(String[] args) {
        int[][] people = {{7,0}, {7,1}, {6,1}, {5,0}, {5,2},{4,4}};
        int[][] res = reconstructQueue(people);
    }

    /**
     * 两个维度：身高与之前元素个数
     * @param people
     * @return
     */
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1]-o2[1];
            } else {
                return o2[0]-o1[0];
            }
        });
        LinkedList<int[]> list = new LinkedList<>();
        for (int i=0;i<people.length;i++) {
            list.add(null);
        }
        for (int[] arr : people) {
            int pos = arr[1];
            if (list.get(pos) == null) {
                list.set(pos, arr);
            } else {
                list.add(pos, arr);
            }
        }
        int[][] res = new int[people.length][2];
        int idx = 0;
        for (int[] arr : list) {
            if (arr != null) {
                res[idx++] = arr;
            }
        }
        return res;
    }

}
