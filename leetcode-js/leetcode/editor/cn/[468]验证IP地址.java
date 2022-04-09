class A468 {

    public static void main(String[] args) {
        System.out.println(new A468().new Solution().validIPAddress(""));
//        System.out.println(new A468().new Solution().validIPAddress("172.16.254.1"));
//        System.out.println(new A468().new Solution().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
//        System.out.println(new A468().new Solution().validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));
        System.out.println(new A468().new Solution().validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String validIPAddress(String queryIP) {

            if (isIPv4(queryIP)) return "IPv4";
            if (isIPv6(queryIP)) return "IPv6";
            return "Neither";

        }

        private boolean isIPv4(String ip) {
            if (ip.length() < 7) return false;
            int n = ip.length();
            if (ip.charAt(0) == '.' || ip.charAt(n - 1) == '.') return false;
            String[] ss = ip.split("\\.");
            if (ss.length != 4) return false;
            for (String s : ss) {
                if (s.length() == 0 || s.length() > 3) return false;
                if (s.charAt(0) == '0' && s.length() > 1) return false;
                int num = 0;
                for (int i = 0; i < s.length(); i++) {
                    int c = s.charAt(i);
                    if (!Character.isDigit(c)) return false;
                    num = num * 10 + (c - '0');
                }
                if (num > 255) return false;
            }

            return true;
        }

        private boolean isIPv6(String ip) {
            if (ip.length() < 15) return false;
            int n = ip.length();
            if (ip.charAt(0) == ':' || ip.charAt(n - 1) == ':') return false;
            String[] ss = ip.split("\\:");
            if (ss.length != 8) return false;
            for (String s : ss) {
                if (s.length() == 0 || s.length() > 4) return false;
                for (int i = 0; i < s.length(); i++) {
                    int c = s.charAt(i);
                    if (!(Character.isDigit(c) || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







