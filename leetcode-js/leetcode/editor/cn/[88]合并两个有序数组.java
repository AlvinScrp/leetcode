class A88 {

    public static void main(String[] args) {
        // System.out.println(new A88().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1, j = n - 1, k = m + n - 1;
            while (i >= 0 || j >= 0) {
                if (j < 0) break;
                if (i < 0) {
                    while (j >= 0) {
                        nums1[k--] = nums2[j--];
                    }
                    break;
                }
                if (nums1[i] > nums2[j]) {
                    nums1[k--] = nums1[i--];
                } else {
                    nums1[k--] = nums2[j--];
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







