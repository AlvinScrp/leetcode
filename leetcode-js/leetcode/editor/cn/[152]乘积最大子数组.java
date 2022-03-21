class A152 {

    public static void main(String[] args) {
        // System.out.println(new A152().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int ans = Integer.MIN_VALUE, max = 1, min = 1;
            for (int num : nums) {
                int a = num * max, b = num * min;
                max = Math.max(Math.max(a, b), num);
                min = Math.min(Math.min(a, b), num);
                ans = Math.max(max, ans);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







