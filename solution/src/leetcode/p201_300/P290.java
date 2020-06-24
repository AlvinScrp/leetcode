package leetcode.p201_300;

import java.util.*;

import static java.util.Collections.singletonList;

public class P290 {

    public boolean wordPattern(String pattern, String str) {

        String[] ss = str.split(" ");
        if (pattern.length() != ss.length) return false;

        Map<Character, Integer> mapP = new HashMap<>();
        Map<String, Integer> mapS = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            String s = ss[i];
            if (mapP.getOrDefault(p, 0) != mapS.getOrDefault(s, 0)) return false;
            if (!mapP.containsKey(p)) {
                mapP.put(p, mapP.size() + 1);
                mapS.put(s, mapS.size() + 1);
            }
        }
        return true;

    }

}
