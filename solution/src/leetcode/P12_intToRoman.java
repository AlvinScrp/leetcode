package leetcode;

import java.util.HashMap;
import java.util.Map;

public class P12_intToRoman {

    public static void main(String[] args) {
//        System.out.println(romanToInt("III"));
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));

    }
//"MCMXCIV"
//    M CM XC IV
//    1000+900+90+4


    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        int tnd = num / 1000;
        num = num % 1000;
        for (int i = 0; i < tnd; i++) {
            sb.append('M');
        }
        appendRoman(sb, num / 100, "CM", "D", "C");
        num = num % 100;
        appendRoman(sb, num / 10, "XC", "L", "X");
        num = num % 10;
        appendRoman(sb, num, "IX", "V", "I");
        return sb.toString();
    }

    private static void appendRoman(StringBuilder sb, int num, String r9, String r5, String r1) {
        if (num > 0) {
            if (num == 9) {
                sb.append(r9);
            } else {
                if (num > 5) {
                    sb.append(r5);
                }
                num = num % 5;
                if (num == 4) {
                    sb.append(r1 + r5);
                } else {
                    for (int i = 0; i < num; i++) {
                        sb.append(r1);
                    }
                }
            }
        }
    }


}
