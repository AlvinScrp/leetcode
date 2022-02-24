package leetcode.p101_200;

import java.util.*;

public class P150 {

    public static void main(String[] args) {
        System.out.println( new P150().evalRPN(new String[]{"4","13","5","/","+"}));
    }

    public int evalRPN(String[] tokens) {

        Deque<Integer> deque = new ArrayDeque<>();
        Set<String> opts = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        for (String token : tokens) {
            if (!opts.contains(token)) {
                deque.addLast(Integer.parseInt(token));
            } else {
                operate(deque, token);
            }
        }
        return deque.isEmpty() ? 0 : deque.peek();


    }

    private void operate(Deque<Integer> deque, String token) {
        int v2 = deque.pollLast();
        int v1 = deque.pollLast();

        if (token.equals("+")) deque.addLast(v1 + v2);
        else if (token.equals("-")) deque.addLast(v1 - v2);
        else if (token.equals("*")) deque.addLast(v1 * v2);
        else if (token.equals("/")) deque.addLast(v1 / v2);
    }


}
