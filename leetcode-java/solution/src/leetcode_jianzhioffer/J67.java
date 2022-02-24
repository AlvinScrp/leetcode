package leetcode_jianzhioffer;

public class J67 {

    /**
     * 输入: "42"   输出: 42
     * <p>
     * 输入: "   -42"  输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     * <p>
     * 输入: "4193 with words"
     * 输出: 4193  解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     * <p>
     * 输入: "words and 987"
     * 输出: 0  解释: 第一个非空字符是 'w', 但它不是数字或正、负号。因此无法执行有效的转换。
     * <p>
     * 输入: "-91283472332"
     * 输出: -2147483648   解释: 数字 "-91283472332" 超过 32 位有符号整数范围。因此返回 INT_MIN (−231) 。
     *
     * @return
     */

    public static void main(String[] args) {
        sout("42");
        sout(" ");
        sout("-42");
        sout("4193 with words");
        sout("  -");
        sout("  -+");
        sout("  +42");
        sout("-91283472332");
        sout("-2147483649");
        sout("2147483648");
    }

    public static void sout(String str) {
        System.out.println(str + ":" + new J67().strToInt(str));
    }

    public int strToInt(String str) {
        if (str == null || str.length() == 0) return 0;

        char[] chars = str.toCharArray();
        int i = 0;
        for (; i < chars.length; i++) {
            if (chars[i] != ' ') break;
        }
        if (i == chars.length) return 0;

        char c = chars[i];
        if (!isFlags(c) && !isDigits(c)) return 0;

        boolean pos = true;
        if (!isDigits(c)) {
            pos = chars[i] == '+';
            i++;
        }

        if (i == chars.length || !isDigits(chars[i])) return 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        int ans = 0;
        for (int j = i; j < chars.length; j++) {
            char ch = chars[j];
            if (!isDigits(ch)) break;
            else {
                int val = ch - '0';
                if (pos && ((ans > max / 10) || (ans == max / 10 && val > 7))) {
                    return Integer.MAX_VALUE;
                } else if (!pos && (ans < min / 10 || (ans == min / 10 && val > 8))) {
                    return Integer.MIN_VALUE;
                }
                ans = ans * 10 + (pos ? val : -val);
            }
        }
        return ans;
    }

    public boolean isDigits(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public boolean isFlags(char ch) {
        return ch == '+' || ch == '-';
    }
}
