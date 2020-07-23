/**
 * @author lyq on 2020-07-23 8:28 下午
 * @desc 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class 加一 {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] res = plusOne(arr);
    }

    public static int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i=digits.length-1;i>=0;i--) {
            int cur = digits[i] + carry;
            carry = cur/10;
            digits[i] = cur%10;
            if (carry == 0) {
                break;
            }
        }
        if (carry > 0) {
            int[] res = new int[digits.length + 1];
            res[0] = carry;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }
        return digits;
    }

}
