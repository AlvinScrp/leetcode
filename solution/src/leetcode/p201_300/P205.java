package leetcode.p201_300;

import java.util.HashMap;
import java.util.Map;

public class P205 {
    public static void main(String[] args) {
        System.out.println(new P205().isIsomorphic("abbcda", "cddefc"));
    }

    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicInner(s, t) && isIsomorphicInner(t, s);
    }

    public boolean isIsomorphicInner(String s, String t) {

        if (s.length() != t.length()) return false;
        if (s.length() <= 1) return true;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) return false;
            } else {
                map.put(c1, c2);
            }
        }

        return true;
    }


}
