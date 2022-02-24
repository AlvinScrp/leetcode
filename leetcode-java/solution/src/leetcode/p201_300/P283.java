package leetcode.p201_300;

import java.util.Arrays;

public class P283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    //    输入: [0,1,0,3,12]
//    输出: [1,3,12,0,0]
    public static void moveZeroes(int[] nums) {

        int n = nums.length;
        if (n <= 1) return;

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < n; i++) {
            nums[j]=0;
        }

    }
}
