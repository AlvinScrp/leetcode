class A718 {

    public static void main(String[] args) {
        System.out.println(new A718().new Solution().findLength(new int[]{0, 0, 0}, new int[]{0, 0}));
        System.out.println(new A718().new Solution().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        // System.out.println(new A718().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int max = 0;

        public int findLength(int[] nums1, int[] nums2) {

            int m = nums1.length, n = nums2.length;
            for (int i = 0; i < m; i++) maxLength(nums1, nums2, i, 0, Math.min(m - i, n));
            for (int j = 0; j < n; j++) maxLength(nums1, nums2, 0, j, Math.min(m, n - j));
            return max;

        }

        private void maxLength(int[] nums1, int[] nums2, int start1, int start2, int len) {
            for (int k = 0, i = 0; i < len; i++) {
                if (nums1[start1 + i] == nums2[start2 + i]) {
                    k++;
                    max = Math.max(max, k);
                } else {
                    k = 0;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







