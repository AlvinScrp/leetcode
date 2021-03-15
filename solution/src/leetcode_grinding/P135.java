package leetcode_grinding;

import java.util.Arrays;

public class P135 {
    public static void main(String[] args) {

    }

    public int candy(int[] ratings) {
        if (ratings.length <= 1) return ratings.length;

        int[] nums = new int[ratings.length];
        Arrays.fill(nums, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                nums[i] = nums[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] >= ratings[i + 1]) {
                nums[i] = Math.max(nums[i], nums[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;

    }
}
