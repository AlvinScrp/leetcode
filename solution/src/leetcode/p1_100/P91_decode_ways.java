package leetcode.p1_100;

public class P91_decode_ways {

    public static void main(String[] args) {

        System.out.println(numDecodings("90"));//0
        System.out.println(numDecodings("226"));//3
        System.out.println(numDecodings("12"));//2

        System.out.println(numDecodings("0"));//0
        System.out.println(numDecodings("10"));//1
        System.out.println(numDecodings("101"));//1
        System.out.println(numDecodings("012"));//0
        System.out.println(numDecodings("903"));//0
        System.out.println(numDecodings("100"));//0
        System.out.println(numDecodings("110"));//1
    }

    /**
     * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
     * 示例 1
     * 输入: "12"
     * 输出: 2
     * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
     * 示例 2:
     * 输入: "226"
     * 输出: 3
     * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     * 链接：https://leetcode-cn.com/problems/decode-ways
     * dp[n]= dp[n-1]+ 1 + (if(a[n-1]*10+a[n]<26)?1:0)
     *
     * @param s
     * @return
     */
    public static int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[n];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i) - '0';
        }

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] == 0) {
                if (a[i - 1] != 1 && a[i - 1] != 2) {
                    return 0;
                }
                dp[i] = (i == 1 ? 1 : dp[i - 2]);
            } else {
                if (a[i - 1] == 1 || (a[i - 1] == 2 && (a[i] >= 1 && a[i] <= 6))) {
                    dp[i] = dp[i - 1] + (i == 1 ? 1 : dp[i - 2]);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }


        return dp[n - 1];
    }
}

