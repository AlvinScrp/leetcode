package leetcode_jianzhioffer;

import java.util.*;

public class J48 {
    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     * <p>
     * 输入: "abcabcbb" 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * <p>
     * 输入: "bbbbb"  输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * <p>
     * <p>
     * 输入: "pwwkew" 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * @return
     */

    public static void main(String[] args) {
        System.out.println(new J48().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new J48().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new J48().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new J48().lengthOfLongestSubstring("abba"));
        System.out.println(new J48().lengthOfLongestSubstring("a"));
        System.out.println(new J48().lengthOfLongestSubstring(" "));
        System.out.println((int) ' ');
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] cis = new int[128];
        Arrays.fill(cis, -1);
        int i = -1, max = 0;
        for (int j = 0; j < s.length(); j++) {
            //i表示当前字符串的前一个字符下标
            i = Math.max(cis[s.charAt(j)], i);
            max = Math.max(max, j - i);
            cis[s.charAt(j)] = j;
        }
        return max;
    }
}
