class A43 {

    public static void main(String[] args) {
//
        System.out.println(new A43().new Solution().multiply("0", "0"));
        System.out.println(new A43().new Solution().multiply("2", "3"));
        System.out.println(new A43().new Solution().multiply("123", "456"));
        System.out.println(123 * 456);
        System.out.println(new A43().new Solution().multiply("9999999", "99999"));
        System.out.println(9999999L * 99999L);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            int m = num1.length(), n = num2.length();
            int[] ans = new int[m + n];
            for (int j = n - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                if (b == 0) continue;
                for (int i = m - 1; i >= 0; i--) {
                    int temp = ans[i + j + 1] + ((num1.charAt(i) - '0') * b);
                    ans[i + j + 1] = temp % 10;
                    if (temp >= 10) ans[i + j] += (temp / 10);
                }
            }
            int start = 0;
            while (ans[start] == 0 && start < ans.length - 1) start++;
            StringBuilder sb = new StringBuilder();
            for (int i = start; i < ans.length; i++) sb.append(ans[i]);
            return sb.toString();

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}







