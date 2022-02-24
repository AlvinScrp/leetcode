package leetcode.divide_and_conquer;

public class P_1560_mianshi_16_17 {

    /**
     * 定一个整数数组，找出总和最大的连续数列，并返回总和。
     * <p>
     * 输入： [-2,1,-3,4,-1,2,1,-5,4]
     * 输出： 6
     * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶：
     * <p>
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int ans = divider(nums, 0, nums.length - 1);
        return ans;
    }

    private int divider(int[] nums, int lo, int hi) {
        if (lo == hi) return nums[lo];

        int mid = (hi - lo) / 2 + lo;
        int L = divider(nums, lo, mid);
        int R = divider(nums, mid + 1, hi);
        int M = maxMiddle(nums, mid, lo, hi);

        return Math.max(Math.max(L, R), M);
    }

    private int maxMiddle(int[] nums, int mid, int lo, int hi) {
        int maxLeft = Integer.MIN_VALUE, left = 0;
        for (int i = mid; i >= 0; i--) {
            left += nums[i];
            maxLeft = Math.max(maxLeft, left);
        }
        int maxRight = Integer.MIN_VALUE, right = 0;
        for (int i = mid + 1; i <= hi; i++) {
            right += nums[i];
            maxRight = Math.max(maxRight, right);
        }
        return maxLeft + maxRight;
    }
}
