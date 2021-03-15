package leetcode.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P664 {

    public static void main(String[] args) {
        System.out.println(new P664().strangePrinter("aaabbb"));
        System.out.println(new P664().strangePrinter("aba"));
        System.out.println(new P664().strangePrinter("abcabc"));

    }

    public int strangePrinter(String s) {
        int n = s.length();
        if (n <= 1) return n;

        int[][] dp = new int[n][n];

        for (int step = 0; step < n; step++) {
            for (int i = 0; i < n && i + step < n; i++) {
                int j = i + step;
                if (step == 0) dp[i][i] = 1;
                else if (step == 1) dp[i][j] = s.charAt(i) == s.charAt(j) ? 1 : 2;
                else {
                    int min = dp[i][j - 1] + 1;
                    for (int k = j - 1; k >= i; k--) {
                        if (s.charAt(k) == s.charAt(j))
                            min = Math.min(min, (k == i ? 0 : dp[i][k - 1]) + dp[k + 1][j]);
                    }
                    dp[i][j] = min;
                }
            }
        }
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
        return dp[0][n - 1];
    }

//    public int strangePrinter(String s) {
//        int n = s.length();
//        if (n < -1) return n;
//
//        int[][] dp = new int[n][n];
//
//
//        for (int step = 0; step < n; step++) {
//            for (int i = 0; i < n && i + step < n; i++) {
//                int j = i + step;
//                if (step == 0) dp[i][i] = 1;
//                else if (step == 1) dp[i][j] = s.charAt(i) == s.charAt(j) ? 1 : 2;
//                else {
////                    dp[i][j] = Integer.MAX_VALUE;
//
//                    String temp = s.substring(i + 1, j);
//                    if (s.charAt(i) == s.charAt(j)) {
//                        boolean contain = temp.indexOf(s.charAt(i)) >= 0;
//                        dp[i][j] = dp[i + 1][j - 1] + (contain ? 0 : 1);
//                    } else {
//                        boolean containI = temp.indexOf(s.charAt(i)) >= 0;
//                        boolean containJ = temp.indexOf(s.charAt(j)) >= 0;
//                        dp[i][j] = dp[i + 1][j - 1] + (containI ? 0 : 1) + (containJ ? 0 : 1);
//                    }
//                }
//            }
//        }
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
//        return dp[0][n - 1];
//    }
}
