package leetcode.p301_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P345 {

    //    输入: "leetcode"
//    输出: "leotcede"
    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels("./"));
    }

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        if (chars.length <= 1) return s;

        Set<Character> yuns = new HashSet<>(Arrays.asList('a', 'o', 'e', 'i', 'u', 'A', 'O', 'E', 'I', 'U'));

        for (int i = 0, j = chars.length - 1; i < j; ) {
            if (!yuns.contains(chars[i])) {
                i++;
                continue;
            } else if (!yuns.contains(chars[j])) {
                j--;
                continue;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }
}
