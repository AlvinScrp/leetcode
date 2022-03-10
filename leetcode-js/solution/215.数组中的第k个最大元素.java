import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */
class A215XX {

    public static void main(String[] args) {
        System.out.println(new A215XX().new Solution().findKthLargest(new int[]{9, 3, 2, 8, 4, 7, 1, 6, 5}, 3));
        System.out.println("sdd");

        int[] nums = new int[]{9, 3, 2, 8, 4, 7, 1, 6, 5};
//        int[] nums = new int[]{5, 1, 2, 6, 4, 3, 9};
//        new A215XX().new Solution().quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    // @lc code=start
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int x = nums.length - k;
            quickSort(nums, 0, nums.length - 1, x);
            return nums[x];
        }

        private void quickSort(int[] nums, int start, int end, int x) {
            if (start >= end) return;
            int pivot = nums[start];
//            int i = start + 1, j = end;
//            while (true) {
//                while (i < j && nums[i] < pivot) i++;
//                while (i < j && nums[j] >= pivot) j--;
//                if (i == j) break;
//                swap(nums, i, j);
//            }
//            if (nums[j] >= pivot) j--;
//            swap(nums, start, j);
            int j = start;
            for (int i = start + 1; i <= end; i++) {
                if (nums[i] < pivot) {
                    j++;
                    swap(nums, i, j);
                }
            }
            swap(nums, start, j);
            if (x < j) {
                quickSort(nums, start, j - 1, x);
            } else if (x > j) {
                quickSort(nums, j + 1, end, x);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
// @lc code=end
}

