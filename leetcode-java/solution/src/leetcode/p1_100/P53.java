package leetcode.p1_100;

public class P53 {

    public int maxSubArray(int[] nums) {

        int max = nums[0], sum = 0;

        for (int num : nums) {
            sum = sum < 0 ? num : (num + sum);
            max = Math.max(sum, max);
        }
        return max;


    }
}
