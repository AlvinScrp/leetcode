package leetcode_contest.biweekly_28;

import java.util.Arrays;

public class P4 {

    public static void main(String[] args) {
        System.out.println();
        System.out.println(new P4().minDistance(new int[]{1, 2, 3, 4, 5, 6}, 10));

    }

    public int minDistance(int[] houses, int k) {

        int n = houses.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 10001);
        int min = Integer.MAX_VALUE;


        for (int i = 0; i < n; i++) {
            int sum = 0;
            int[] temp = Arrays.copyOf(dp, n);
            for (int j = 0; j < n; j++) {
                temp[j] = Math.min(dp[j], Math.abs(houses[j] - houses[i]));
                sum += temp[j];
            }
            if (sum < min) {
                dp = temp;
                min = sum;
            }

        }
        return min;

    }


}
