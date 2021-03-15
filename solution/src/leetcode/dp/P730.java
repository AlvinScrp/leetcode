package leetcode.dp;

import java.util.*;

public class P730 {
    /**
     * 给定一个字符串 S，找出 S 中不同的非空回文子序列个数，并返回该数字与 10^9 + 7 的模。
     * <p>
     * 通过从 S 中删除 0 个或多个字符来获得子序列。
     * <p>
     * 如果一个字符序列与它反转后的字符序列一致，那么它是回文字符序列。
     * <p>
     * 如果对于某个  i，A_i != B_i，那么 A_1, A_2, ... 和 B_1, B_2, ... 这两个字符序列是不同的。
     * <p>
     *  
     * 输入：
     * S = 'bccb'
     * 输出：6
     * 解释：
     * 6 个不同的非空回文子字符序列分别为：'b', 'c', 'bb', 'cc', 'bcb', 'bccb'。
     * 注意：'bcb' 虽然出现两次但仅计数一次。
     * 示例 2：
     * <p>
     * 输入：
     * S = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
     * 输出：104860361
     * 解释：
     * 共有 3104860382 个不同的非空回文子序列，对 10^9 + 7 取模为 104860361。
     *  
     * <p>
     * 提示：
     * 字符串 S 的长度将在[1, 1000]范围内。
     * 每个字符 S[i] 将会是集合 {'a', 'b', 'c', 'd'} 中的某一个。
     */

    public static void main(String[] args) {
        System.out.println(new P730().countPalindromicSubsequences("bccb"));
        System.out.println(new P730().countPalindromicSubsequences("bcbacbabdcbcbdcbddcaaccdcbbcdbcabbcdddadaadddbdbbbdacbabaabdddcaccccdccdbabcddbdcccabccbbcdbcdbdaada"));
        System.out.println(new P730().countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));

    }

    public int countPalindromicSubsequences(String S) {
        int MOD = 1000000007;
        int n = S.length();

        int[][] dp = new int[n][n];
        for (int step = 0; step < n; step++) {
            for (int i = 0; i < n && i + step < n; i++) {
                int j = i + step;
                if (step <= 1) {
                    dp[i][j] = step == 0 ? 1 : 2;
                } else {
                    if (S.charAt(i) != S.charAt(j)) {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    } else {
                        int lo = i + 1, hi = j - 1;
                        for (; lo <= hi && S.charAt(lo) != S.charAt(i); lo++) ;
                        for (; lo <= hi && S.charAt(hi) != S.charAt(j); hi--) ;

                        int temp = (dp[i + 1][j - 1] * 2 + 2);//ababa  +2:a,aa
                        if (lo == hi) {
                            dp[i][j] = temp - 1; //ababa  -1:与中间a重复
                        } else if (lo > hi) {
                            dp[i][j] = temp;
                        } else if (lo < hi) {
                            dp[i][j] = temp - dp[lo + 1][hi - 1] - 2; //aabbaa  a-bb-a 与 -abba-重复
                        }
                    }
                    dp[i][j] = dp[i][j] < 0 ? dp[i][j] + MOD : dp[i][j] % MOD;
                }
            }
        }
        return dp[0][n - 1];
    }

//    public long countPalindromicSubsequences(String S) {
//
//
//        int MOD = 1000000007;
//        int n = S.length();
//
//        long[][] dp = new long[n][n];
//        for (int step = 0; step < n; step++) {
//            for (int i = 0; i < n && i + step < n; i++) {
//                int j = i + step;
//                if (j - i <= 1) {
//                    dp[i][j] = j - i == 0 ? 1 : 2;
//                } else {
//                    if (S.charAt(i) != S.charAt(j)) {
//                        dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1]);
//                    } else {
//                        int lo = i + 1, hi = j - 1;
//                        for (; S.charAt(lo) != S.charAt(i); lo++) ;
//                        for (; S.charAt(hi) != S.charAt(j); hi--) ;
//
//                        long temp = dp[i + 1][j - 1] * 2;
//                        if (lo == hi) {
//                            //ababa  +2:a,aa -1:与中间a重复
//                            dp[i][j] = temp + 2 - 1;
//                        } else if (lo > hi) {
//                            //abba  +2:a,aa
//                            dp[i][j] = temp + 2;
//                        } else if (lo < hi) {
//                            //aabbaa  a-bb-a 与 -abba-重复
//                            dp[i][j] = temp + 2 - dp[lo + 1][hi - 1];
//                        }
//                    }
//                    dp[i][j] = dp[i][j];
//                }
//
//            }
//        }
//        return dp[0][n - 1];
//
//
//    }


}
