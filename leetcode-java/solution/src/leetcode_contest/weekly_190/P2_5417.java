package leetcode_contest.weekly_190;

import java.util.*;

public class P2_5417 {

    public static void main(String[] args) {

        System.out.println(new P2_5417().maxVowels("abciiidef", 3));
        System.out.println(new P2_5417().maxVowels("leetcode", 3));
        System.out.println(new P2_5417().maxVowels("rhythms", 4));
        System.out.println(new P2_5417().maxVowels("tryhard", 4));

    }

    public int maxVowels(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        Queue<Integer> queue = new ArrayDeque<>();
        s = s.toLowerCase();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            while (!queue.isEmpty() && queue.peek() <= i - k) {
                queue.poll();
            }
            if (isAeiou(s.charAt(i))) {
                queue.offer(i);
            }
            if (i >= k - 1) {
                max = Math.max(max, queue.size());
            }
        }
        return max;
    }

    public boolean isAeiou(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
