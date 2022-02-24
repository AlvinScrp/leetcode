package leetcode_jianzhioffer;

import java.util.Arrays;

public class J50 {
    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     * s = "abaccdeff"
     * 返回 "b"
     * <p>
     * s = ""  返回 " "
     */
    public char firstUniqChar(String s) {
        int[] counts = new int['z' + 1];
        Arrays.fill(counts, 0);
        char[] chars = s.toCharArray();
        for (char c : chars) counts[c]++;
        for (char c : chars) {
            if (counts[c] == 1) return c;
        }
        return ' ';
    }
}
