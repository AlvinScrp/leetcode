package leetcode_jianzhioffer;

import java.util.Arrays;

public class J60 {
    /**
     * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
     * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
     * <p>
     * 输入: 1
     * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
     * <p>
     * 输入: 2
     * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
     *
     * @return
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new J60().twoSum(2)));

        J60 j60 = new J60();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            j60.sumCount1(100);
        }
        System.out.println("cost1:" + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            j60.sumCount2(100);
        }
        System.out.println("cost2:" + (System.currentTimeMillis() - time));


    }

//    public double[] twoSum(int n) {
//        int max = n * 6, min = n * 1;
//        int[] ans = new int[n * 6 + 1];
//        Arrays.fill(ans, 0);
//        count = 0;
//        dfs(n, 0, ans);
//
//        double[] res = new double[max - min + 1];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = ans[i + min] / (count * 1.0d);
//        }
//        System.out.println(Arrays.toString(ans));
//        return res;
//    }
//
//    int count;
//
//    private void dfs(int n, int sum, int[] ans) {
//        if (n == 0) {
//            ans[sum]++;
//            count++;
//            return;
//        }
//        for (int i = 1; i <= 6; i++) {
//            dfs(n - 1, sum + i, ans);
//        }
//    }
    //============================================================================================

    public double[] twoSum(int n) {
        if (n == 0) return new double[]{0};

        int count = 0;
        int[] counts = sumCount1(n);
        for (int i : counts) {
            count += i;
        }

//        System.out.println(Arrays.toString(counts));
        int max = n * 6, min = n * 1;
        double[] res = new double[max - min + 1];

        for (int i = 0; i < res.length; i++) {
            res[i] = counts[i + min] / (count * 1.0d);
        }
        return res;
    }

    private int[] sumCount1(int n) {

        if (n == 1) {
            return new int[]{0, 1, 1, 1, 1, 1, 1};
        }
        int[] counts = sumCount1(n / 2);
        int[] res = merge(counts, counts);
        if (n % 2 == 1) {
            res = merge(res, sumCount1(1));
        }
        return res;
    }

    public int[] merge(int[] counts1, int[] counts2) {
        int[] res = new int[counts1.length - 1 + counts2.length - 1 + 1];
        for (int i = 0; i < counts1.length; i++) {
            for (int j = 0; j < counts2.length; j++) {
                res[i + j] += counts1[i] * counts2[j];
            }
        }
        return res;
    }

    //============================================================================================

    private int[] sumCount2(int n) {

        int[][] dp = new int[n + 1][6 * n + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, 0);
        }
        Arrays.fill(dp[1], 1, 7, 1);
        for (int i = 2; i <= n; i++) {
            int maxIndex = 6 * i;
            for (int j = 0; j <= maxIndex; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k >= 0) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }
        return dp[n];
    }
}
