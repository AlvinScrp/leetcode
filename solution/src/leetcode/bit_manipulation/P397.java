package leetcode.bit_manipulation;

public class P397 {

    /**
     * 给定一个正整数 n，你可以做如下操作：
     * 1. 如果 n 是偶数，则用 n / 2替换 n。
     * 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
     * n 变为 1 所需的最小替换次数是多少？
     * <p>
     * 输入: 8
     * 输出: 3
     * 8 -> 4 -> 2 -> 1
     * <p>
     * 输入:7
     * 输出:4
     * 解释:
     * 7 -> 8 -> 4 -> 2 -> 1
     * 或
     * 7 -> 6 -> 3 -> 2 -> 1
     *
     * @return
     */

    public static void main(String[] args) {
        int n = 100000000;
//        System.out.println(integerReplacement(8));
//        System.out.println(integerReplacement(7));
//        System.out.println(integerReplacement2(n));
        System.out.println(integerReplacement4(n));


    }


    public static int integerReplacement4(int n) {
        if (n <= 1) return 0;
        if (n == 2147483647) return 32;

        int count = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n = n >> 1;
            } else {
                if ((n & 2) == 0 || n == 3) {
                    n = n - 1;
                } else {
                    n = n + 1;
                }
            }
            count++;

        }
        return count;
    }

    public static int integerReplacement2(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {

            if (i % 2 == 0) {
                dp[i] = dp[i / 2] + 1;
            } else if (i % 2 == 1) {
                dp[i] = Math.min(dp[(i - 1) / 2], dp[(i + 1) / 2]) + 2;
            }
        }
        return dp[n];
    }
}
