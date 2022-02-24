package leetcode.bit_manipulation;

public class P388 {
    /**
     * 给定两个字符串 s 和 t，它们只包含小写字母。
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     * 请找出在 t 中被添加的字母。
     * 输入：
     * s = "abcd"
     * t = "abcde"
     * <p>
     * 输出：
     * e
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans ^= s.charAt(i) ^ t.charAt(i);
        }
        ans ^= t.charAt(t.length() - 1);
        return (char) ans;

    }
}
