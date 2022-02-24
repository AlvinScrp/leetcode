package leetcode.dp;

public class P213 {

    public static void main(String[] args) {
        System.out.println( new P213().rob(new int[]{1,2,3,1}));
    }

    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));

    }

    public int rob(int[] nums, int start, int end) {

        int n = nums.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][2];

        dp[start][0] = 0;
        dp[start][1] = nums[start];

        for (int i = start + 1; i <= end; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[end][0], dp[end][1]);
    }
}
