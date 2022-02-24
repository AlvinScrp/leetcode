package leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P312 {
    /**
     * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
     * 现在要求你戳破所有的气球。
     * 每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 
     * 这里的 left 和 right 代表和 i 相邻的两个气球的序号。
     * 注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
     * <p>
     * 求所能获得硬币的最大数量。
     * <p>
     * 说明:
     * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
     * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
     * 示例:
     * <p>
     * 输入: [3,1,5,8]
     * 输出: 167
     * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
     *
     * @return
     */


    public static void main(String[] args) {
        System.out.println(new P312().maxCoins(new int[]{3, 1, 5, 8}));
    }


    int[] a;
    int[][] dp;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        a = new int[n + 2];
        a[0] = 1;
        a[n + 1] = 1;
        for (int i = 0; i < n; i++) a[i + 1] = nums[i];

        dp = new int[n + 2][n + 2];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dp(0, n + 1);
    }

    private int dp(int i, int j) {

        if (dp[i][j] < 0) {
            if (i + 1 == j) {
                dp[i][j] = 0;
            } else {
                int coins = -1;
                for (int k = i + 1; k < j; k++) {
                    coins = Math.max(coins, dp(i, k) + dp(k, j) + a[i] * a[k] * a[j]);
                }
                if (coins >= 0) {
                    dp[i][j]= coins;
                }
            }
        }else {
            System.out.println(i+","+j+":"+dp[i][j]);
        }
        return dp[i][j];
    }


}
