package leetcode_contest.weekly_287;

import java.util.*;

public class P6055 {

    public static void main(String[] args) {
//        System.out.println(new P2().minDeletion(new int[]{1, 1, 2, 3, 5}));
//        System.out.println(new P1().minDeletion(new int[]{1, 1, 2, 2, 3, 3}));

    }

    public List<List<Integer>> findWinners(int[][] matches) {
        //统计出现，并失败次数
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] match : matches) {
            if (!map.containsKey(match[0])) {
                map.put(match[0], 0);
            }
            map.put(match[1], map.getOrDefault(match[1], 0) + 1);
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new LinkedList<>());
        ans.add(new LinkedList<>());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            int person = entry.getKey();
            if (count <= 1) {
                ans.get(count).add(person);
            }
        }
        return ans;
    }


}
