package leetcode.p1_100;

import java.util.Arrays;

public class P16_3sum_closest {
    public static void main(String[] args) {
        int[] height = {-1,2,1,-4};
//        int[] height2 = {0, 0, 0, 0};
        System.out.println(threeSumClosest(height,1));
//        System.out.println(threeSum(height2));
    }

    /**
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     * <p>
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum-closest
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return nums[0] + nums[1];
        }
        int last = nums[0] + nums[1] + nums[length - 1];
        for (int i = 1; i < length; i++) {
            int left = 0, right = length - 1;
            while (left < i && i < right) {
                int sum = nums[left] + nums[i] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
                if (Math.abs(target - sum) < Math.abs(target - last)) {
                    last = sum;
                }
            }

        }
        return last;

    }
}
