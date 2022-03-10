class A42 {

    public static void main(String[] args) {
        System.out.println(new A42().new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {

            int i = 0, j = height.length - 1;
            int maxLeft = 0, maxRight = 0;
            int ans = 0;
            while (i < j) {
                if (height[i] < height[j]) {
                    if (height[i] > maxLeft) {
                        maxLeft = height[i];
                    } else {
                        ans += (maxLeft - height[i]);
                    }
                    i++;
                } else {
                    if (height[j] > maxRight) {
                        maxRight = height[j];
                    } else {
                        ans += (maxRight - height[j]);
                    }
                    j--;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}