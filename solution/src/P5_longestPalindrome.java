public class P5_longestPalindrome {

    public static void main(String[] args) {
        System.out.println("babad:" + longestPalindrome("babad"));
        System.out.println("eeedee:" + longestPalindrome("eeedee"));
        System.out.println("nonnon:" + longestPalindrome("nonnon"));
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     */
//    public static String longestPalindrome(String s) {
//        int length = s.length();
//        if (length<=1){
//            return s;
//        }
//        int maxLength = 1;
//        int startIndex = 0;
//        for (int i = 0; i < length; i++) {
//            int p = i - 1, q = i + 1;
//            //奇数
//            while (p >= 0 && q < length && s.charAt(p) == s.charAt(q)) {
//                p--;
//                q++;
//            }
//            if (maxLength < q - p - 1) {
//                maxLength = q - p - 1;
//                startIndex = p + 1;
//            }
//            //偶数
//            int m = i, n = i + 1;
//            while (m >= 0 && n < length && s.charAt(m) == s.charAt(n)) {
//                m--;
//                n++;
//            }
//            if (maxLength < (n - m - 1)) {
//                maxLength = n - m - 1;
//                startIndex = m + 1;
//            }
//        }
//        return s.substring(startIndex, startIndex + maxLength);
//    }
    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        byte[] bytes = s.getBytes();
        int maxLength = 1;
        int startIndex = 0;
        for (int i = 0; i < length; i++) {
            int p = i - 1, q = i + 1;
            //奇数
            while (p >= 0 && q < length && bytes[p] == bytes[q]) {
                p--;
                q++;
            }
            if (maxLength < q - p - 1) {
                maxLength = q - p - 1;
                startIndex = p + 1;
            }
            //偶数
            int m = i, n = i + 1;
            while (m >= 0 && n < length && bytes[m] == bytes[n]) {
                m--;
                n++;
            }
            if (maxLength < (n - m - 1)) {
                maxLength = n - m - 1;
                startIndex = m + 1;
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }


//    public static String longestPalindrome(String s) {
//        int length = s.length();
//        if (length <= 1) {
//            return s;
//        }
//        byte[] bytes = s.getBytes();
//        int maxLength = 1;
//        int startIndex = 0;
//        for (int i = 0; i < length; i++) {
//            int r1 = 1;
//            //奇数
//            while (i - r1 >= 0 && i + r1 < length && bytes[i - r1] == bytes[i + r1]) {
//                r1++;
//            }
//            int newLength1 = (r1 << 1) - 1;
//            if (maxLength < newLength1) {
//                maxLength = newLength1;
//                startIndex = i - r1 + 1;
//            }
//
//            //偶数
//            int r2 = 0;
//            while (i - r2 >= 0 && i + r2 + 1 < length && bytes[i - r2] == bytes[i + r2 + 1]) {
//                r2++;
//            }
//            int newLength2 = (r2 << 1);
//            if (maxLength < newLength2) {
//                maxLength = newLength2;
//                startIndex = i - r2 + 1;
//            }
//        }
//        return s.substring(startIndex, startIndex + maxLength);
//    }
}
