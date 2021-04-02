package leetcode.p1_100;

import java.util.Arrays;

public class P45 {

    public static void main(String[] args) {
        System.out.println(new P45().jump(new int[]{2, 3, 1, 1, 4}));
    }

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = dp[i] == -1 ? (dp[j] + 1) : Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }
}
