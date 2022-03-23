class A468 {

    public static void main(String[] args) {
        System.out.println(new A468().new Solution()
                .validIPAddress("12.12.12.12.12"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String validIPAddress(String queryIP) {

            if (parseIP4(queryIP)) {
                return "IPv4";
            } else if (parseIP6(queryIP)) {
                return "IPv6";
            } else {
                return "Neither";
            }

        }

        private boolean parseIP4(String queryIP) {
            if (queryIP.startsWith(".") || queryIP.endsWith(".")) return false;
            String[] ip4 = queryIP.split("\\.");
            if (ip4 == null || ip4.length != 4) return false;
            for (String u : ip4) {
                if (u.length() == 0 || u.length() > 3) return false;
                if (u.charAt(0) == '0' && u.length() > 1) return false;
                int num = 0;
                for (int i = 0; i < u.length(); i++) {
                    char c = u.charAt(i);
                    if (c < '0' || c > '9') return false;
                    num = num * 10 + (c - '0');
                }
                if (num > 255) return false;
            }
            return true;
        }

        private boolean parseIP6(String queryIP) {
            if (queryIP.startsWith(":") || queryIP.endsWith(":")) return false;
            String[] ip6 = queryIP.split("\\:");
            if (ip6 == null || ip6.length != 8) return false;
            for (String u : ip6) {
                if (u.length() == 0 || u.length() > 4) return false;
//                int num = 0;
                for (int i = 0; i < u.length(); i++) {
                    char c = u.charAt(i);
                    boolean isDigit = c >= '0' && c <= '9';
                    boolean isUpperLetter = c >= 'a' && c <= 'f';
                    boolean isLowerLetter = (c >= 'A' && c <= 'F');
                    if (!(isDigit || isUpperLetter || isLowerLetter)) return false;
//                    num = num * 16 + (isDigit ? (c - '0') : (c - 'a' + 10));
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







