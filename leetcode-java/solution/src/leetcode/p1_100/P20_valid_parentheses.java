package leetcode.p1_100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P20_valid_parentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }


    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!stack.empty() && stack.peek() == map.get(aChar)) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.isEmpty();
    }
    /**
     *  给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     *         有效字符串需满足：
     *
     *         左括号必须用相同类型的右括号闭合。
     *         左括号必须以正确的顺序闭合。
     *         注意空字符串可被认为是有效字符串。
     *
     *         示例 1:
     *
     *         输入: "()"
     *         输出: true
     *         示例 2:
     *
     *         输入: "()[]{}"
     *         输出: true
     *         示例 3:
     *
     *         输入: "(]"
     *         输出: false
     *
     *         来源：力扣（LeetCode）
     *         链接：https://leetcode-cn.com/problems/valid-parentheses
     *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
}
