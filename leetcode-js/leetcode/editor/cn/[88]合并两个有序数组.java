class A88 {

    public static void main(String[] args) {
//        new A88().new Solution().merge();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (nums1.length < 1 || nums2.length < 1) return;
            int i = m - 1, j = n - 1, k = m + n - 1;
            while (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[k] = nums1[i];
                    k--;
                    i--;
                } else {
                    nums1[k] = nums2[j];
                    k--;
                    j--;
                }
            }
            if (i < 0) {
                while (j >= 0) {
                    nums1[j] = nums2[j];
                    j--;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}