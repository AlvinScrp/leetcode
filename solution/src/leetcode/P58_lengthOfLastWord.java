package leetcode;

public class P58_lengthOfLastWord {
    public static void main(String[] args) {

    }

    public int lengthOfLastWord(String s) {
        if (s == null || s == "") {
            return 0;
        }
        int length = s.length();
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (isBlank(ch)) {
                if (count > 0) {
                    return count;
                }

            } else if (isLetter(ch)) {
                count++;
            }

        }
        return count;

    }

    public static boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public static boolean isBlank(char ch) {
        return ch == ' ';
    }
}
