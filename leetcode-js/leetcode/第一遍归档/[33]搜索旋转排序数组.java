class A33 {

    public static void main(String[] args) {
//        System.out.println(new A33().new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
//        System.out.println(new A33().new Solution().search(new int[]{3, 4, 5, 6, 7, 8, 9, 0, 1, 2,}, 2));
        System.out.println(new A33().new Solution().search(new int[]{3, 1}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            return binSearch(nums, 0, nums.length - 1, target);
        }

        //        int[] nums = {3, 4, 5, 6, 7, 8, 9, 0, 1, 2,}; target=2
        private int binSearch(int[] nums, int i, int j, int target) {
            if (i > j) return -1;
            int k = i + (j - i) / 2;
            if (target == nums[k]) return k;
         
            if (nums[i] <= nums[k]) {
                if (nums[i] <= target && target <= nums[k]) {
                    return binSearch(nums, i, k - 1, target);
                } else {
                    return binSearch(nums, k + 1, j, target);
                }
            } else {
                if (nums[k] <= target && target <= nums[j]) {
                    return binSearch(nums, k + 1, j, target);
                } else {
                    return binSearch(nums, i, k - 1, target);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}