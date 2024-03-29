class A415 {

    public static void main(String[] args) {
//        System.out.println(new A415().new Solution().addStrings("11", "123"));
        System.out.println(new A415().new Solution().addStrings("8999999", "1"));
//        System.out.println(new A415().new Solution().addStrings("0", "0"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int i = num1.length() - 1, j = num2.length() - 1;
            StringBuilder res = new StringBuilder();
            int carry = 0;
            while (i >= 0 || j >= 0) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                int temp = x + y + carry;
                carry = temp >= 10 ? 1 : 0;
                res.append(temp % 10);
                i--;
                j--;
            }
            if (carry > 0) res.append(carry);
            return res.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}