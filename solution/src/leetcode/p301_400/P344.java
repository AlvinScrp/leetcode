package leetcode.p301_400;

public class P344 {

    public void reverseString(char[] s) {

        if (s.length <= 1) return;

        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

    }
}
