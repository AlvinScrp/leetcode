class A198 {

    public static void main(String[] args) {
        // System.out.println(new A198().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {

            int a = 0, b = 0, temp = 0;
            for (int num : nums) {
                temp = a;
                a = Math.max(a, b);
                b = temp + num;
            }
            return Math.max(a, b);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







