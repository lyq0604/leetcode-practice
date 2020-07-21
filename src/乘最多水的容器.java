/**
 * @author lyq on 2020-07-16 11:27 下午
 * @desc 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class 乘最多水的容器 {

    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length-1;
        while (left < right) {
            int temp = Math.min(height[left], height[right]) * (right-left);
            res = Math.max(res, temp);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

}
