package leetcode.p101_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P131 {

    public static void main(String[] args) {
        List<List<String>> res =new P131().partition("aab");
        for (List<String> re : res) {
            System.out.println(re);
        }
    }

    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();
        int n = s.length();
        if (n == 0) return res;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; i - k >= 0 && i + k < n; k++) {
                if (s.charAt(i - k) != s.charAt(i + k)) break;
                dp[i - k][i + k] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int k = 0; i - k >= 0 && i + k + 1 < n; k++) {
                if (s.charAt(i - k) != s.charAt(i + k + 1)) break;
                dp[i - k][i + k + 1] = 1;
            }
        }

        dfs(s, 0, n, new LinkedList<>(), res, dp);
        return res;
    }

    private void dfs(String s, int i, int n, LinkedList<String> path, List<List<String>> res, int[][] dp) {

        if (i == s.length()) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int j = i; j < n; j++) {
            if (dp[i][j] == 1) {
                path.addLast(s.substring(i, j + 1));
                dfs(s, j+1, n, path, res, dp);
                path.removeLast();
            }
        }
    }
}
