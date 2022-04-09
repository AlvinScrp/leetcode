class A11 {

    public static void main(String[] args) {
        // System.out.println(new A11().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int n = height.length;
            int max = 0;
            for (int l = 0, r = n - 1; l < r; ) {
                int h = height[l], p = r - l;
                if (height[l] < height[r]) {
                    l++;
                } else if (height[l] > height[r]) {
                    h = height[r];
                    r--;
                } else {
                    l++;
                    r--;
                }
                max = Math.max(max, h * p);
            }
            return max;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







