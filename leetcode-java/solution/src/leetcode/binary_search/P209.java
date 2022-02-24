package leetcode.binary_search;

import java.util.PriorityQueue;

public class P209 {

    //输入: s = 7, nums = [2,3,1,2,4,3]
    //输出: 2
    //解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。

    public int minSubArrayLen1(int s, int[] nums) {


        int sum = 0;
        for (int num : nums) sum += num;
        if (sum < s) return 0;

        int min = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min;
    }

    //输入: s = 7, nums = [2,3,1,2,4,3]
    //输出: 2
    //解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
    public int minSubArrayLen2(int s, int[] nums) {

        int sum = 0;
        for (int num : nums) sum += num;
        if (sum < s) return 0;

        int min = nums.length;

        sum = nums[0];
        for (int i = 0, j = 0; i <= j && j < nums.length; ) {

            if (sum >= s) {
                if (i == j) return 1;
                min = Math.min(min, j - i + 1);
                sum -= nums[i];
                i++;
            } else {
                if (j + 1 == nums.length) break;
                sum += nums[++j];
            }


        }
        return min;
    }

    //输入: s = 7, nums = [2,3,1,2,4,3]
    //输出: 2
    //解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
    public int minSubArrayLen3(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] += nums[i] + sums[i - 1];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int s2 = s + (i > 0 ? sums[i - 1] : 0);
            int j = binarySearch(sums, s2, i, nums.length - 1);
            if (j >= 0) {
                ans = Math.min(ans, j - i + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private static int binarySearch(int[] sums, int s2, int lo, int hi) {
        if (lo >= hi) return sums[hi] >= s2 ? hi : -1;
        int mid = (hi - lo) / 2 + lo;
        if (s2 == sums[mid]) return mid;
        if (s2 < sums[mid]) return binarySearch(sums, s2, lo, mid);
        else return binarySearch(sums, s2, mid + 1, hi);
    }


}
