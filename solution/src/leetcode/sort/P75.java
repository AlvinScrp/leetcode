package leetcode.sort;

import java.util.Arrays;

public class P75 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P75().sortColors(new int[]{2, 0, 2, 1, 1, 0})));
        System.out.println(Arrays.toString(new P75().sortColors(new int[]{2, 0, 1, 1, 0, 1, 2, 1, 1, 0})));
        System.out.println(Arrays.toString(new P75().sortColors(new int[]{2, 0, 1})));
        System.out.println(Arrays.toString(new P75().sortColors(new int[]{0, 0})));
    }

    //输入: [2,0,2,1,1,0]
    //输出: [0,0,1,1,2,2]
    public int[] sortColors(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return nums;

        int i = 0, j = nums.length - 1;

        while (i < j) {
            if (nums[i] == 0) i++;
            else if (nums[j] == 2) j--;
            else if (nums[j] == 0 || nums[i] == 2) swap(nums, i, j);
            else {
                //均为1
                int k = i + 1;
                while (nums[k] == 1 && k < j) k++;
                if (k == j) break;
                if (nums[k] == 0) {
                    swap(nums, i, k);
                    i++;
                } else {
                    swap(nums, j, k);
                    j--;
                }
            }
        }

        return nums;


    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;

    }
}
