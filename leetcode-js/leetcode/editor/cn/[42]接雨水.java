class A42 {

    public static void main(String[] args) {
        // System.out.println(new A42().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            if (n <= 2) return 0;
            int[] l = new int[n], r = new int[n];

            //i左侧元素的最大高度，不包括i位置
            for (int i = 1; i < n; i++) {
                l[i] = i == 0 ? 0 : Math.max(l[i - 1], height[i - 1]);
            }
            for (int i = n - 2; i >= 0; i--) {
                r[i] = i == n - 1 ? 0 : Math.max(r[i + 1], height[i + 1]);
            }
            int count = 0;
            for (int i = 1; i < n - 1; i++) {
                count += Math.max(0, Math.min(l[i], r[i]) - height[i]);
            }
            return count;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







