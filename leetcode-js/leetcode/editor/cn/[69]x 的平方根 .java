class A69 {

    public static void main(String[] args) {
        System.out.println(new A69().new Solution().mySqrt(1000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {

            long a = x;
            while (a * a > x) {
                a = (a + x / a) / 2;
            }
            return (int) a;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







