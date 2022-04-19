package leetcode_contest.weekly_289;

import java.util.ArrayList;

public class P6073 {
    int ans = 0;
    ArrayList<Integer>[] list;
    String s;

    public int longestPath(int[] parent, String s) {
        list = new ArrayList[parent.length];
        this.s = s;
        for (int i = 0; i < parent.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < parent.length; i++) {
            list[parent[i]].add(i);
        }
        dfs(0);
        return ans;
    }

    private int dfs(int i) {
        int a = 0, b = 0;
        for (Integer child : list[i]) {
            int h = dfs(child);
            if (s.charAt(i) != s.charAt(child)) {
                if (h > a) {
                    b = a;
                    a = h;
                } else if (h > b) {
                    b = h;
                }
            }
        }
        ans = Math.max(ans, a + b + 1);
        return a + 1;
    }
}
