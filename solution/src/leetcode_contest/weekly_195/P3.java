package leetcode_contest.weekly_195;

import java.util.Arrays;

public class P3 {

    public static void main(String[] args) {
        System.out.println(new P3().numSubseq(new int[]{3,5,6,7}, 9));
        System.out.println(new P3().numSubseq(new int[]{5, 2, 4, 1, 7, 6, 8}, 16));

    }

    /**
     * 4,8,2,1,9
     * 输入：nums = [3,5,6,7], target = 9
     * 输出：4
     * 解释：有 4 个子序列满足该条件。
     * [3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
     * [3,5] -> (3 + 5 <= 9)
     * [3,5,6] -> (3 + 6 <= 9)
     * [3,6] -> (3 + 6 <= 9)
     *
     * @param nums
     * @param target
     * @return
     */

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        long count = 0;
        for (int i = 0; i < nums.length && nums[i] < target / 2 + 1; i++) {
//            int j=binarySearch(nums,target,i);
            int j=i;
            for (; j < nums.length; j++) {
               if(nums[i]+nums[j]>target) break;
            }
            j=j-1;
            count = (pow2(j  - i) + count) % 1000000007;
        }
        return (int) count;
    }



    private long pow2(int n) {
        if (n == 0) return 1;
        if (n == 1) return 2;
        long val = pow2(n / 2) % 1000000007l;
        val = (val * val) % 1000000007l;
        return (val * pow2(n % 2)) % 1000000007l;
    }

    private int binarySearch(int[] nums, int target,int i){

        int lo = i, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nums[i] + nums[mid] <= target) {
                if (mid + 1 < nums.length && nums[i] + nums[mid + 1] <= target) {
                    lo = mid + 1;
                } else {
                    lo = hi = mid;
                }
            } else {
                hi = mid - 1;
            }
        }
        return lo;

    }


}
