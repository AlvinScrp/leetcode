/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

import java.util.*;

class A15 {
    public static void main(String[] args) {
//        System.out.println(new Solution().binarySearch(new int[]{-4, -1, -1, 0, 1, 2}, 2, 4, -1));
        System.out.println(new A15().new Solution().threeSum(new int[]{-4, -1, -1, 0, 1, 2}));
        System.out.println(new A15().new Solution().threeSum(new int[]{0, 0, 0}));
        ;
    }

    // @lc code=start
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> res = new HashSet<>();
            if (nums.length < 3) return new ArrayList<>();
            Arrays.sort(nums);


            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) break;
                for (int j = i + 2; j < nums.length; j++) {
                    if (nums[j] < 0) continue;
                    int findX = -(nums[i] + nums[j]);
                    int k = binarySearch(nums, i + 1, j - 1, findX);
                    if (k > i && k < j) {
                        res.add(Arrays.asList(nums[i], nums[k], nums[j]));
                    }
                }
            }
            return new ArrayList<>(res);

        }

        public int binarySearch(int[] nums, int i, int j, int value) {
            if (i > j) return -1;
            int k = i + (j - i) / 2;
            if (nums[k] == value) return k;
            if (value > nums[k]) return binarySearch(nums, k + 1, j, value);
            else return binarySearch(nums, i, k - 1, value);
        }
    }
// @lc code=end
}
