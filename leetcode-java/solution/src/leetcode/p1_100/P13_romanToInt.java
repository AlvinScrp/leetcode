package leetcode.p1_100;

import java.util.HashMap;
import java.util.Map;

public class P13_romanToInt {

    public static void main(String[] args) {
//        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("MCMXCIV"));

    }

//    M CM XC IV
//    1000+900+90+4

    public static int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] chars = s.toCharArray();
        int length = chars.length;
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i < length - 1) {
                if (chars[i] == 'I' && chars[i + 1] == 'V') {
                    sum += 4;
                    i++;
                    continue;
                } else if (chars[i] == 'I' && chars[i + 1] == 'X') {
                    sum += 9;
                    i++;
                    continue;
                } else if (chars[i] == 'X' && chars[i + 1] == 'L') {
                    sum += 40;
                    i++;
                    continue;
                } else if (chars[i] == 'X' && chars[i + 1] == 'C') {
                    sum += 90;
                    i++;
                    continue;
                } else if (chars[i] == 'C' && chars[i + 1] == 'D') {
                    sum += 400;
                    i++;
                    continue;
                } else if (chars[i] == 'C' && chars[i + 1] == 'M') {
                    sum += 900;
                    i++;
                    continue;
                }
            }
            if (map.containsKey(chars[i])) {
                sum += map.get(chars[i]);
            }
        }
        return sum;


    }


}
