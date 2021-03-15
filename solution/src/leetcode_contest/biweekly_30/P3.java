package leetcode_contest.biweekly_30;

import java.util.Arrays;

public class P3 {

    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{6, 6, 0, 1, 1, 4, 6}) + ",2");

    }

    public static int minDifference(int[] nums) {

        if (nums.length <= 4) return 0;

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int i = 0, j = nums.length - 1;
        int ans = nums[j] - nums[i];
        for (int k = 0; k <= 3; k++) {
            ans = Math.min(nums[j - (3 - k)] - nums[i + k], ans);
        }
        return ans;

    }


}
