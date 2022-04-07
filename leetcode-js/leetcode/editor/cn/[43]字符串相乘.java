class A43 {

    public static void main(String[] args) {
        System.out.println(new A43().new Solution().multiply("123", "456"));
//        System.out.println(new A43().new Solution().multiply("999", "99"));
//        System.out.println(999 * 99);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            int m = num1.length(), n = num2.length();
            int[] ans = new int[m + n];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int k = i + j + 1;
                    ans[k] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                }
            }
            for (int k = ans.length - 1; k > 0; k--) {
                if (ans[k] >= 10) {
                    ans[k - 1] += ans[k] / 10;
                    ans[k] = ans[k] % 10;
                }
            }
            int k = 0;
            for (; k < ans.length && ans[k] == 0; k++) ;
            StringBuilder sb = new StringBuilder();
            for (; k < ans.length; k++) sb.append(ans[k]);
            return sb.length() == 0 ? "0" : sb.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







