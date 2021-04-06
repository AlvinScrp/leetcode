package leetcode.p201_300;

import java.util.LinkedList;
import java.util.Stack;

public class P227 {

    public static void main(String[] args) {
        System.out.println(new P227().calculate("3+2*2"));
        System.out.println(new P227().calculate("3/2 "));
        System.out.println(new P227().calculate("3+5/2"));
        System.out.println(new P227().calculate("0-2147483647"));
    }

    public int calculate(String s) {
//        int k=-2147483647;
        int l = s.length();
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < l; ) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                do {
                    num = (num * 10) + (s.charAt(i) - '0');
                    i++;
                } while (i < l && Character.isDigit(s.charAt(i)));

                if (ops.isEmpty()) {
                    nums.push(num);
                    continue;
                }
                char op = ops.peek();
                if (op == '*' || op == '/') {
                    int a = nums.pop(), b = num;
                    nums.push(op == '*' ? a * b : a / b);
                } else {
                    nums.push(op == '-' ? -num : num);
                }

            } else {
                ops.push(s.charAt(i));
                i++;
            }
        }
        int res = 0;
        while (!nums.isEmpty()) res += nums.pop();
        return res;
    }
}
