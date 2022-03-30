class A11 {

    public static void main(String[] args) {
        // System.out.println(new A11().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int ans = 0;
            int i = 0, j = height.length - 1;
            while (i < j) {
                ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
                if (height[i] < height[j]) i++;
                else j--;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







