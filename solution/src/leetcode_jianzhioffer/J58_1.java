package leetcode_jianzhioffer;

public class J58_1 {
    public static void main(String[] args) {
        System.out.println(new J58_1().reverseWords(" the sky is blue"));
    }

    /**
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int i = s.length() - 1, j = i;
        while (i >= -1) {
            if (i == -1 || chars[i] == ' ') {
                if (i != j) append(sb, chars, i + 1, j);
                i--;
                j = i;
            } else {
                i--;
            }
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();

    }

    private void append(StringBuilder sb, char[] chars, int i, int j) {
        for (int k = i; k <= j; k++) {
            sb.append(chars[k]);
        }
        sb.append(' ');
    }
}
