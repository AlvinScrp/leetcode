class A357 {

    public static void main(String[] args) {
        // System.out.println(new A357().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            int[] f = new int[n + 1];

            f[0] = 1;
//            f[1] = 10;
            int pre = 9;
            for (int i = 1; i <= n; i++) {
                f[i] = f[i - 1] + pre;
                pre = pre * (10 - i);
            }
            return f[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







