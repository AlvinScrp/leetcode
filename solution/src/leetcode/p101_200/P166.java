package leetcode.p101_200;

import java.util.HashMap;
import java.util.Map;

public class P166 {

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(2, 3));
        System.out.println(fractionToDecimal(2, 99));
        System.out.println(fractionToDecimal(1, 100));
        System.out.println(fractionToDecimal(4, 333));
//        System.out.println(1/17.0);


    }

    public static String fractionToDecimal(int numerator, int denominator) {
        long a = numerator, b = denominator;

        String ans = "";
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            ans = "-";
        }

        a=Math.abs(a);
        b=Math.abs(b);

        StringBuilder sb = new StringBuilder();
        sb.append(a / b);
        Map<Long, Integer> map = new HashMap<>();


        a = a % b;
        if (a != 0) sb.append(".");
        while (true) {
            if (a == 0) {
                ans += sb.toString();
                break;
            } else if (map.containsKey(a)) {
                int index = map.get(a);
                ans += (sb.substring(0, index) + "(" + sb.substring(index) + ")");
                break;
            }
            sb.append(a * 10 / b);
            map.put(a, sb.length() - 1);
            a = a * 10 % b;
        }
        return ans;

    }
}
