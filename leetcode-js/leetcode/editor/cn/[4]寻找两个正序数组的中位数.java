class A4 {

    public static void main(String[] args) {
        System.out.println(new A4().new Solution()
                .findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7}));
        System.out.println(new A4().new Solution()
                .findMedianSortedArrays(new int[]{3}, new int[]{-2, -1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            int k = (m + n + 1) / 2;
            if (m > n) return findMedianSortedArrays(nums2, nums1);
            int l = 0, r = m;
            while (l < r) {
                int i = l + (r - l) / 2;
                int j = k - i;
                if (nums1[i] < nums2[j - 1]) {
                    l = i + 1;
                } else {
                    r = i;
                }
            }
            int i = l, j = k - i;
            int mL = i == 0 ? -1000001 : nums1[i - 1];
            int nL = j == 0 ? -1000001 : nums2[j - 1];
            int mR = i >= m ? 1000001 : nums1[i];
            int nR = j >= n ? 1000001 : nums2[j];

            if ((m + n) % 2 == 0) {
                return (Math.max(mL, nL) + Math.min(mR, nR)) * 0.5d;
            } else {
                return Math.max(mL, nL) * 1.0d;
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







