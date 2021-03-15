package leetcode_contest.weekly_197;

import java.util.Arrays;

public class P2 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString("010011".split("0")));

        System.out.println(numSub(""));
    }


    public static int numSub(String s) {

        long ans = 0;
        String[] strs = s.split("0");
        for (String str : strs) {
            if (str.contains("1")) {
                long n = str.length();
                ans =(ans+ (n + 1) * n / 2)%1000000007;
            }
        }
        return (int) ans;

    }


}
