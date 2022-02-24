package leetcode.p1_100;

public class P53_maximum_subarray {


    public static void main(String[] args) {


        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("maxSubArray:" + maxSubArray(nums1));

    }

    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
             currentSum = Math.max(currentSum + nums[i], nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }


}
