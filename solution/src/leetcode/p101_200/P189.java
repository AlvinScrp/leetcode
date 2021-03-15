package leetcode.p101_200;

import java.util.Arrays;

public class P189 {

    public static void main(String[] args) {
        new P189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        new P189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3);
        new P189().rotate(new int[]{-1, -100, 3, 99}, 2);
        new P189().rotate(new int[]{1, 2, 3, 4, 5, 6}, 3);
        new P189().rotate(new int[]{1, 2, 3, 4, 5, 6}, 4);
    }

//    输入: nums = [1,2,3,4,5,6,7], k = 3
//    输出: [5,6,7,1,2,3,4]
//    解释:
//    向右旋转 1 步: [7,1,2,3,4,5,6]
//    向右旋转 2 步: [6,7,1,2,3,4,5]
//    向右旋转 3 步: [5,6,7,1,2,3,4]
    //向右旋转 4 步: [4,5,6,7,1,2,3]
    //向右旋转 5 步: [3,4,5,6,7,1,2]

    public void rotate(int[] nums, int k) {

        if (nums == null) return;
        int n = nums.length;
        if (n == 0 || k % n == 0) return;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

        System.out.println(Arrays.toString(nums));

    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
