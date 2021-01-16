package 栈;

import java.util.Stack;

/**
 * @author lyq on 2021-01-16 下午8:45
 * @desc 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。  在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */
public class 删除字符串中的所有相邻重复项 {

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                Character top = stack.peek();
                if (c.equals(top)) {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        char[] newChars = new char[s.length()];
        while (!stack.isEmpty()) {
            Character c = stack.pop();
            newChars[stack.size()] = c;
        }
        return String.valueOf(newChars);
    }

}
