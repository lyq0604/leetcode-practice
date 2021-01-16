package 队列;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author lyq on 2021-01-16 下午10:05
 * @desc 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class 前K个高频元素 {

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        int[] tops = topKFrequent(arr, 2);
        System.out.println(Arrays.toString(tops));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        if (nums.length == 0) return arr;
        Map<Integer, Integer> map= new HashMap<>();
        for (int i : nums) {
            Integer val = map.get(i);
            if (val == null) {
                map.put(i, 1);
            } else {
                map.put(i, ++val);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(map.size(), (o1, o2) -> {
            return o2.getValue() - o1.getValue();
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }
        for (int i=0;i<k;i++) {
            arr[i] = queue.poll().getKey();
        }
        return arr;
    }

}
