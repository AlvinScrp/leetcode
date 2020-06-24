package leetcode.dp;

import java.util.Arrays;

public class P416 {
    public static void main(String[] args) {
        System.out.println(new P416().canPartition(new int[]{1, 2, 3, 4}));
        System.out.println(new P416().canPartition(new int[]{1, 5, 11, 3}));
        System.out.println(new P416().canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(new P416().canPartition(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    public boolean canPartition(int[] nums) {
        if (nums.length < 2) return false;

        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;
        sum = sum >> 1;

        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int num : nums) {
            for (int i = dp.length - 1; i > 0; i--) {
                if (i - num >= 0 && dp[i - num]) {
                    dp[i] = true;
                }
            }
        }
        return dp[sum];
//        return dp[sum >> 1];


    }
}
