package 堆;

/**
 * @author lyq on 2021-01-07 下午8:33
 * @desc
 */
public class Trace {

    private int[] arr;

    private int size;

    // 计数
    private int count;

    public Trace(int n) {
        arr = new int[n];
        size = n;
        count = 0;
    }

    /**
     * 插入元素
     * @param val
     */
    public void insert(int val) {
        // 堆满
        if (count == size) return;
        int i = count;
        arr[i] = val;
        count++;
        while (i/2>0 && arr[i/2]<arr[i]) {
            int tmp = arr[i/2];
            arr[i/2] = arr[i];
            arr[i] = tmp;
            i/=2;
        }
    }

    /**
     * 移出堆顶元素
     */
    public void remove() {
        if (count == 0) return;
        arr[0] = arr[--count];
        this.heapify(0);
    }

    /**
     * 自上而下堆化
     * @param i 堆顶开始位置
     */
    private void heapify(int i) {
        while (true) {
            int maxPos = i;
            // 判断左子节点大小
            if ((2*i+1) <= count && arr[2*i+1] > arr[i]) {
                maxPos = 2*i+1;
            }
            // 判断右子节点大小
            if ((2*i+2) <= count && arr[maxPos] < arr[2*i+2]) {
                maxPos = 2*i+2;
            }
            if (maxPos == i){
                break;
            }
            // 交换
            int tmp = arr[maxPos];
            arr[maxPos] = arr[i];
            arr[i] = tmp;
            i = maxPos;
        }
    }
}
