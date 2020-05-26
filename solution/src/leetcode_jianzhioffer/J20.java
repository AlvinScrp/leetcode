package leetcode_jianzhioffer;

public class J20 {

    public static void main(String[] args) {
//        prints("+100");
//        prints("5e2");
//        prints("3.1416");
//        prints("0123");
//        prints("12e");
//        prints("1a3.14");
//        prints("1.2.3");
//        prints("+-5");
//        prints("-1E-16");
//        prints("12e+5.4");
        prints(".1");
//        prints("46.e3");
        prints(" 005047e+6");

//        prints("1.");
    }

    public static void prints(String s) {
        System.out.println("" + s + ":" + new J20().isNumber(s));
    }

    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
     * 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
     */
//    X = (-1)s×(1.M)×2 E-127       e = E-127   E为阶码即指数的真值
    public boolean isNumber(String s) {

        if (s == null || s.length() == 0) return false;
        s = s.trim();
        if (s.length() == 0) return false;

        char ch = s.charAt(0);
        if (!isSign(ch) && !isDigits(ch) && !isDots(ch)) return false;
        int i = isSign(ch) ? 1 : 0;

        boolean hasDigits = false, hasDots = false, hasE = false;
        for (int j = i; j < s.length(); j++) {
            char c = s.charAt(j);
            boolean isDots = isDots(c), isDigits = isDigits(c), isE = isE(c), isSign = isSign(c);
            if (isDots) {
                if (hasDots || hasE) return false;
            } else if (isE) {
                if (hasE || !hasDigits) return false;
            } else if (isSign) {
                if (!(hasE && isE(s.charAt(j - 1)))) return false;
            } else if (isDigits) {

            } else {
                return false;
            }

            hasDigits = hasDigits || isDigits;
            hasDots = hasDots || isDots;
            hasE = hasE || isE;
        }
        char cl = s.charAt(s.length() - 1);
        return hasDigits && !isE(cl) && !isSign(cl);
    }

    private boolean isDigits(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isSign(char c) {
        return c == '+' || c == '-';
    }

    private boolean isDots(char c) {
        return c == '.';
    }

    private boolean isE(char c) {
        return c == 'e';
    }
}
