class A152 {

    public static void main(String[] args) {
        // System.out.println(new A152().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int ans = Integer.MIN_VALUE, min = 1, max = 1;
            for (int num : nums) {
                int a = num * min, b = num * max;
                max = Math.max(num, Math.max(a, b));
                min = Math.min(num, Math.min(a, b));
                ans = Math.max(ans, max);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







