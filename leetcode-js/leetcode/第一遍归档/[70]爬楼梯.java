class A70 {

    public static void main(String[] args) {
        // System.out.println(new A70().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {

            int f0 = 1, f1 = 1;
            for (int i = 2, temp; i <= n; i++) {
                temp = f1;
                f1 = f0 + f1;
                f0 = temp;
            }
            return f1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







