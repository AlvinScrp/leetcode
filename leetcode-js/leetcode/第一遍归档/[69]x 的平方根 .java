class A69 {

    public static void main(String[] args) {


        System.out.println(new A69().new Solution().mySqrt(102));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int a) {
            if (a <= 1) return a;

            int x = a;
            while (x * x > a) {

                x = (x + a / x) / 2;
                System.out.println(x);

            }
            return (int) x;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







