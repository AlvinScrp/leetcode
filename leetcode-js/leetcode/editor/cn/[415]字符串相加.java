class A415 {

    public static void main(String[] args) {
        // System.out.println(new A415().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int m = num1.length(), n = num2.length();
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            for (int i = m - 1, j = n - 1; i >= 0 || j >= 0;i--,j-- ) {
                int a = i < 0 ? 0 : (num1.charAt(i) - '0');
                int b = j < 0 ? 0 : (num2.charAt(j) - '0');
                int value = a + b + carry;
                carry = value / 10;
                sb.insert(0, value % 10);
            }
            if (carry > 0) sb.insert(0, 1);
            return sb.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







