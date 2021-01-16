package 栈;

import java.util.Stack;

/**
 * @author lyq on 2021-01-16 下午8:35
 * @desc
 */
public class 有效的括号 {

    public static void main(String[] args) {
        System.out.println(judge("{[]}"));
    }

    public static boolean judge(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else {
                Character top = stack.pop();
                if (c == ')' && top == '(') {
                    continue;
                } else if (c == ']' && top == '[') {
                    continue;
                } else if (c == '}' && top == '{') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
