package leetcode.p1_100;

import java.util.Arrays;

public class P80 {
    public static void main(String[] args) {
        System.out.println(new P80().removeDuplicates(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 4, 4, 4, 5}));
        System.out.println(new P80().removeDuplicates2(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 4, 4, 4, 5}));
    }

    public int removeDuplicates2(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 2) return nums.length;

        int count = 1, j = 1;
        for (int i = 1; i < nums.length; i++) {
            count = nums[i] == nums[i - 1] ? (count + 1) : 1;
            if (count <= 2) nums[j++] = nums[i];
        }
        return j;

    }

    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 2) return nums.length;

        resetDuplicates(nums);
        return moveForward(nums);
    }

    private int moveForward(int[] nums) {
        int i = 0, j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != Integer.MIN_VALUE) continue;
            if (j <= i) j = i + 1;
            while (j < nums.length && nums[j] == Integer.MIN_VALUE) j++;
            if (j == nums.length) break;
            nums[i] = nums[j];
            nums[j] = Integer.MIN_VALUE;
        }
//        System.out.println(Arrays.toString(nums));
        return i;
    }

    private void resetDuplicates(int[] nums) {
        int num = Integer.MIN_VALUE;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != num) {
                count = 1;
                num = nums[i];
            } else {
                if (count == 2) {
                    nums[i] = Integer.MIN_VALUE;
                } else {
                    count++;
                }
            }
        }
//        System.out.println(Arrays.toString(nums));
    }
}
