class A70 {

    public static void main(String[] args) {
        // System.out.println(new A70().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            int a = 1, b = 1, temp;
            for (int i = 2; i <= n; i++) {
                temp = b;
                b = a + b;
                a = temp;
            }
            return b;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







