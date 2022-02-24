package leetcode.p1_100;

import java.util.Arrays;

public class P43 {

//    输入: num1 = "123", num2 = "456"
//    输出: "56088"

    public static void main(String[] args) {
        System.out.println(99 * 99);
        System.out.println(multiply("99", "99"));
    }

    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) return "0";

        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int l1 = num1.length(), l2 = num2.length();
//        int[] nums1 = toArray(num1), nums2 = toArray(num2);
        int[] ans = new int[l1 + l2];

        int val;
        for (int j = l2 - 1; j >= 0; j--) {
            int ch2 =num2.charAt(j)-'0';
            for (int i = l1 - 1; i >= 0; i--) {
                int ch1 =num1.charAt(i)-'0';
                val = ans[i + j + 1] + ch1 * ch2;
                ans[i + j + 1] = val % 10;
                ans[i + j] += val / 10;
            }
        }
        int i = 0;
        for (; ans[i] == 0; i++) ;
        StringBuilder sb=new StringBuilder(l1+l2);
        for (int j = i; j < ans.length; j++) {
            sb.append(ans[j]);
        }
        return sb.toString();
    }

    public static int[] toArray(String num1) {
        int[] num1s = new int[num1.length()];
        for (int i = 0; i < num1.length(); i++) {
            num1s[i] = num1.charAt(i) - '0';
        }
        return num1s;
    }
}
