class A8 {

    public static void main(String[] args) {
        // System.out.println(new A8().new Solution());
        System.out.println(Integer.MIN_VALUE % 10);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int myAtoi(String s) {
            s = s.trim();
            if (s.length() == 0) return 0;

            int i = 0;
            int flag = 1;
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (s.charAt(i) == '-') flag = -1;
                i++;
            }
            int max = Integer.MAX_VALUE / 10, min = Integer.MIN_VALUE / 10;
            int num = 0;
            for (; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!Character.isDigit(c)) break;
                int d = c - '0';
                if (flag > 0) {
                    if (num > max || (num == max && d > 7)) {
                        num = Integer.MAX_VALUE;
                        break;
                    }
                } else {
                    if (num < min || (num == min && d > 8)) {
                        num =  Integer.MIN_VALUE;
                        break;
                    }
                }
                num = num * 10 + (flag * d);
            }
            return num;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







