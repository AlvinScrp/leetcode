package leetcode.p101_200;

public class P125 {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) return true;
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; ) {
            if (!valid(s.charAt(i))) i++;
            else if (!valid(s.charAt(j))) j--;
            else if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;

    }

    public boolean valid(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

}
