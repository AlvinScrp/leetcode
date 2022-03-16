class A198 {

    public static void main(String[] args) {
        // System.out.println(new A198().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int f0 = 0, f1 = 0, temp;
            for (int num : nums) {
                temp = f0;
                f0 = Math.max(f0, f1);
                f1 = temp + num;
            }
            return Math.max(f0, f1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







