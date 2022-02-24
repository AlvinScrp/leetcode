package grokking_algorithms;

import java.util.Arrays;

/**

 */
public class P4_divide_conquer_3_binary_search {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4};
        int target = -3;
        System.out.println(binarySearch(nums, target));
    }

    public static int binarySearch(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static int binarySearch(int[] nums, int left, int right, int target) {

        if (left > right) {
            return -1;
        }
        int middle = (right - left) / 2+left;
        int index;
        if (nums[middle] == target) {
            index = middle;
        } else if (target > nums[middle]) {
            index = binarySearch(nums, middle + 1, right, target);
        } else {
            index = binarySearch(nums, left, middle-1, target);
        }
        return index;
    }
}
