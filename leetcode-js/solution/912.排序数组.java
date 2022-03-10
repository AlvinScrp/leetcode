/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */
class A912 {


    // @lc code=start
    class Solution {
        public int[] sortArray(int[] nums) {
            if (nums == null || nums.length <= 1) return nums;
            quick(nums, 0, nums.length - 1);
            return nums;
        }

        public void quick(int[] nums, int start, int end) {
            if (start >= end) return;
            int pivot = nums[start];
            int i = start + 1, j = end;
            while (true) {
                while (i < j && nums[i] < pivot) i++;
                while (i < j && nums[j] >= pivot) j--;
                if (i == j) break;
                swap(nums, i, j);
            }
            if (nums[j] > pivot) {
                j--;
            }
            swap(nums, start, j);
            quick(nums, start, j - 1);
            quick(nums, j + 1, end);

        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
// @lc code=end
}

