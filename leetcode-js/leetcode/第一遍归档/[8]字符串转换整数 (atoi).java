class A8 {

    public static void main(String[] args) {
        System.out.println(new A8().new Solution().myAtoi(" 4567abc"));
        System.out.println(new A8().new Solution().myAtoi(" -4567abc"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int myAtoi(String s) {

            s = s.trim();
            if (s.length() == 0) return 0;

            boolean positive = true;
            int start = 0;
            char cs = s.charAt(0);
            if (cs == '+' || cs == '-') {
                positive = cs == '+';
                start = 1;
            } else if (cs < '0' || cs > '9') {
                return 0;
            }
            int ans = 0;
            int max = Integer.MAX_VALUE;
            int min = Integer.MIN_VALUE;
            for (int i = start; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c < '0' || c > '9') break;
                int value = (positive ? 1 : -1) * (c - '0');
                if (positive && (ans > max / 10 || (ans == max / 10 && value > max % 10))) {
                    return max;
                } else if (!positive && (ans < min / 10 || (ans == min / 10 && value < min % 10))) {
                    return min;
                }
                ans = ans * 10 + value;
            }

            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







