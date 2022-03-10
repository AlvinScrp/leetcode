class A415 {

    public static void main(String[] args) {
//        System.out.println(new A415().new Solution().addStrings("11", "123"));
        System.out.println(new A415().new Solution().addStrings("8999999", "1"));
//        System.out.println(new A415().new Solution().addStrings("0", "0"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int m = num1.length(), n = num2.length();
            int i = m - 1, j = n - 1;
            char[] res = new char[Math.max(m, n) + 1];
            int k = res.length - 1;
            int carry = 0;

            while (i >= 0 || j >= 0) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                int temp = x + y + carry;
                carry = temp >= 10 ? 1 : 0;
                res[k] = (char) ((temp % 10) + '0');
                i--;
                j--;
                k--;
            }
            res[k] = (char) (carry + '0');
            String s = new String(res);
            if (carry == 0) {
                s = s.substring(1);
            }
            return s;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}