package leetcode.dp;

import java.util.Arrays;

public class P494 {

    public static void main(String[] args) {
        System.out.println(new P494().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 4));
    }


    /**
     * 输入：nums: [1, 1, 1, 1, 1], S: 3
     * 输出：5
     * 解释：
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     */
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return S == 0 ? 1 : 0;

        int sum = 0;
        for (int num : nums) sum += num;
        if (S > sum || S < -sum) return 0;

        int m = nums.length, n = (sum << 1);
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], 0);
        dp[0][sum] = 1;
//        System.out.println(Arrays.toString(dp[0]));
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j - nums[i - 1] >= 0) dp[i][j] += dp[i - 1][j - nums[i - 1]];
                if (j + nums[i - 1] <= n) dp[i][j] += dp[i - 1][j + nums[i - 1]];
            }
//            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[m][S + sum];
    }
}
