package leetcode.divide_and_conquer;

import java.util.ArrayList;
import java.util.List;

public class P241 {
    public static void main(String[] args) {
        new P241().diffWaysToCompute("2-1-1");
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i < input.length(); i++) {
            if (isOp(input.charAt(i))) {
                List<Integer> x = diffWaysToCompute(input.substring(0, i));
                List<Integer> y = diffWaysToCompute(input.substring(i + 1, input.length()));
//                System.out.println("x,y:"+input.substring(0, i)+","+input.substring(i + 1, input.length()));
                res.addAll(compute(input.charAt(i), x, y));
            }
        }
        if(res.isEmpty()) {
            res.add(Integer.parseInt(input));
        }
        return res;

    }

    private List<Integer> compute(char op, List<Integer> xx, List<Integer> yy) {
//        if (xx.isEmpty()) return yy;
//        if (yy.isEmpty()) return xx;
        List<Integer> res = new ArrayList<>();
        for (Integer x : xx) {
            for (Integer y : yy) res.add(op(op, x, y));
        }
        return res;
    }

    private int op(char op, int a, int b) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        return a * b;
    }

    private boolean isOp(char op) {
        return op == '+' || op == '-' || op == '*';
    }
}
