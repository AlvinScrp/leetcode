package grokking_algorithms;

import java.util.Arrays;

/**

 */
public class P4_divide_conquer_2_maxnumber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(maxNumber(nums));
    }

    public static int maxNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxNumber = Math.max(maxNumber(Arrays.copyOf(nums, nums.length - 1)), nums[nums.length - 1]);
        return maxNumber;
    }
}
