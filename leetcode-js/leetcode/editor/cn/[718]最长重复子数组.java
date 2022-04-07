class A718 {

    public static void main(String[] args) {
        // System.out.println(new A718().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            return Math.max(findLengthHelper(nums1, nums2), findLengthHelper(nums2, nums1));
        }

        public int findLengthHelper(int[] nums1, int[] nums2) {

            int m = nums1.length, n = nums2.length;
            int max = 0;
            for (int i = 0; i < m; i++) {
                int len = Math.min(m - i, n);
                if (len <= max) break;
                int count = 0;
                for (int k = 0; k < len; k++) {
                    if (nums1[i + k] == nums2[k]) count++;
                    else {
                        max = Math.max(max, count);
                        count = 0;
                        if (len - (k + 1) <= max) break;
                    }
                }
                max = Math.max(max, count);
            }

            return max;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}







