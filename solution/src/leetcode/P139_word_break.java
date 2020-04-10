package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P139_word_break {

    public static void main(String[] args) {

    }

    public static boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        Set<String> words = new HashSet<>(wordDict);
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && words.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];

    }
}
