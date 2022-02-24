package leetcode_contest.weekly_191;

import java.util.Arrays;

public class P1 {

    public static void main(String[] args) {
        System.out.println();

    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);

    }


}
