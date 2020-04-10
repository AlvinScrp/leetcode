package leetcode;

public class P152_maximum_product_subarray {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, -2, 4};
        int[] nums2 = {-2, 0, 1};
        int[] nums3 = {-2, 3, -4};
        int[] nums4 = {3, -1, 4};
        int[] nums5 = {-4, -3, -2};

        System.out.println(maxProduct(nums1));
        System.out.println(maxProduct(nums2));
        System.out.println(maxProduct(nums3));
        System.out.println(maxProduct(nums4));
        System.out.println(maxProduct(nums5));

    }

    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
     * <p>
     * 示例 1:
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * <p>
     * -2, 0, 1
     * 1
     * <p>
     * 示例 2
     * 输入: [-2,3, -4]
     * 输出: 24
     *
     * @param nums
     * @return
     */

    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            int currentImin = imin * nums[i];
            int currentImax = imax * nums[i];
            imax = Math.max(Math.max(currentImin, currentImax), nums[i]);
            imin = Math.min(Math.min(currentImin, currentImax), nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }

//    public static int maxProduct(int[] nums) {
//        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
//        for(int i=0; i<nums.length; i++){
//            if(nums[i] < 0){
//                int tmp = imax;
//                imax = imin;
//                imin = tmp;
//            }
//            imax = Math.max(imax*nums[i], nums[i]);
//            imin = Math.min(imin*nums[i], nums[i]);
//
//            max = Math.max(max, imax);
//        }
//        return max;
//    }


}
