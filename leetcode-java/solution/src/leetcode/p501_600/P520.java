package leetcode.p501_600;

public class P520 {
    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        int count = 0;
        for (char aChar : chars) if (aChar >= 'A' && aChar <= 'Z') count++;
        return count == chars.length || count == 0 || (count == 1 && Character.isUpperCase(chars[0]));

    }
}
