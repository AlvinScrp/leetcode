package leetcode_contest.weekly_230;

import java.util.Arrays;

public class P5691 {

    public static void main(String[] args) {
        int result = new P5691().minOperations(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 2, 2, 2, 2});
        System.out.println(result);
    }

    public int minOperations(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int sum1 = 0, sum2 = 0;
        for (int num1 : nums1) sum1 += num1;
        for (int num2 : nums2) sum2 += num2;
        return sum1 < sum2 ? min(sum1, sum2, nums1, nums2) : min(sum2, sum1, nums2, nums1);

    }

    private int min(int sum1, int sum2, int[] nums1, int[] nums2) {
        int count = 0;
        for (int i = 0, j = nums2.length - 1; sum1 < sum2; count++) {
            if (i >= nums1.length && j < 0) break;
            else if (i == nums1.length) sum2 -= nums2[j--] - 1;
            else if (j < 0) sum1 += 6 - nums1[i++];
            else if (6 - nums1[i] > nums2[j] - 1) sum1 += 6 - nums1[i++];
            else sum2 -= nums2[j--] - 1;
        }
        return sum1 < sum2 ? -1 : count;
    }
}

