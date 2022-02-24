package leetcode.p301_400;

import java.util.HashMap;
import java.util.Map;

public class P383 {

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] cache = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            cache[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (cache[ch - 'a'] <= 0) return false;
            cache[ch - 'a']--;
        }
        return true;

    }
}
