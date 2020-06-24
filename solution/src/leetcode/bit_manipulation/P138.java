package leetcode.bit_manipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P138 {
    /**
     * 给定一个字符串数组 words，
     * 找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。
     * 你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
     * <p>
     * <p>
     * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
     * 输出: 16
     * 解释: 这两个单词为 "abcw", "xtfn"。
     * <p>
     * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
     * 输出: 4
     * 解释: 这两个单词为 "ab", "cd"。
     * <p>
     * 输入: ["a","aa","aaa","aaaa"]
     * 输出: 0
     * 解释: 不存在这样的两个单词。
     *
     * @return
     */

    public static void main(String[] args) {
        System.out.println(maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println(maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
    }

    public static int maxProduct(String[] words) {
        if (words == null || words.length <= 1) return 0;
        int ans = 0, n = words.length;

        int[] masks = new int[128];
        for (int i = 0; i < 26; i++) {
            masks['a' + i] = 1 << i;
        }
        System.out.println(Arrays.toString(masks));

        Map<Integer, Integer> bits = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = words[i];
            int bit = 0;
            for (int j = 0; j < s.length(); j++) {
                bit |= masks[s.charAt(j)];
            }
            if (!bits.containsKey(bit) || bits.get(bit) < s.length()) {
                bits.put(bit, s.length());
            }

        }
        for (Integer bit1 : bits.keySet()) {
            for (Integer bit2 : bits.keySet()) {
                if ((bit1 & bit2) == 0) {
                    ans = Math.max(ans, bits.get(bit1) * bits.get(bit2));
                }
            }
        }


        return ans;


    }


}
