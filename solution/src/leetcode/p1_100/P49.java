package leetcode.p1_100;

import java.util.*;

public class P49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = String.valueOf(chars);
            if (!map.containsKey(temp)) {
                map.put(temp, new ArrayList<>());
            }
            map.get(temp).add(str);

        }

        return new ArrayList<>(map.values());

    }
}
