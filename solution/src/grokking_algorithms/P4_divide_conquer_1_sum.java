package grokking_algorithms;

import java.util.Arrays;

/**
 * 小麦地均分成最大正方形块
 */
public class P4_divide_conquer_1_sum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(sum(nums));
    }

    public static int sum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = sum(Arrays.copyOf(nums, nums.length - 1)) + nums[nums.length - 1];
        return sum;
    }
}
