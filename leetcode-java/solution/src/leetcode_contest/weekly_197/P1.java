package leetcode_contest.weekly_197;

import java.util.Arrays;

public class P1 {

    public static void main(String[] args) {

        System.out.println();
    }

    public int numIdenticalPairs(int[] nums) {

        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) ans++;
            }
        }
        return ans;

    }




}
