package leetcode_jianzhioffer;

import java.util.Arrays;

public class J51 {

    public static void main(String[] args) {
        System.out.println(new J51().reversePairs(new int[]{1, 7, 2, 9, 6, 4, 5, 3}));
    }

    public int reversePairs(int[] nums) {

        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        int ans = cal(nums, 0, nums.length - 1, temp);
//        System.out.println(Arrays.toString(nums));
        return ans;
    }

    private int cal(int[] nums, int lo, int hi, int[] temp) {
        if (lo >= hi) return 0;
        int mid = (hi - lo) / 2 + lo;
        int left = cal(nums, lo, mid, temp);
        int right = cal(nums, mid + 1, hi, temp);
        int mergeCount = nums[mid] < nums[mid + 1] ? 0 : mergeAndCount(nums, lo, mid, hi, temp);
        return left + right + mergeCount;

    }

    public int mergeAndCount(int[] nums, int lo, int mid, int hi, int[] temp) {
        int count = 0, i = lo, j = mid + 1, k = lo;
        for (int n = lo; n <= hi; n++) {
            temp[n] = nums[n];
        }

        while (k <= hi) {
            if (i > mid) nums[k++] = temp[j++];
            else if (j > hi) nums[k++] = temp[i++];
            else {
                if (temp[i] > temp[j]) {
                    count += (mid - i + 1);
                    nums[k++] = temp[j++];
                } else {
                    nums[k++] = temp[i++];
                }
            }
        }
        return count;
    }
}
