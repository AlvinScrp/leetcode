package leetcode_contest.weekly_194;

import java.util.*;

public class P2 {

    public static void main(String[] args) {
        System.out.println();
        System.out.println(
                Arrays.toString(
                        new P2().getFolderNames(new String[]{"gta", "gta(1)", "gta", "avalon"})));
        System.out.println(
                Arrays.toString(
                        new P2().getFolderNames(new String[]{"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"})));
        System.out.println(
                Arrays.toString(
                        new P2().getFolderNames(new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)"})));

    }


    public String[] getFolderNames(String[] names) {
        if (names == null || names.length == 0) return new String[0];
        if (names.length == 1) return new String[]{names[0]};

        Map<String, Integer> map = new HashMap<>();
        String[] ans = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {
                map.put(name, 1);
                ans[i] = name;
            } else {
                while (true) {
                    String temp = name + "(" + map.get(name) + ")";
                    if (map.containsKey(temp)) {
                        map.put(name, map.get(name) + 1);
                    }else {
                        map.put(temp, 1);
                        ans[i] = temp;
                        break;
                    }
                }
            }
        }
        return ans;

    }


}
