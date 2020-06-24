package leetcode.dp;

import java.util.Arrays;

public class P300 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int ans = 1;
        for (int value : dp) {
            ans = Math.max(ans, value);
        }
        return ans;
    }
}
