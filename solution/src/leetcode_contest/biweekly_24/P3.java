package leetcode_contest.biweekly_24;

import java.util.LinkedList;

/**
 * 长度为 n 的开心字符串中字典序第 k 小的字符串
 */
public class P3 {

    public static void main(String[] args) {
        System.out.println(getHappyString(1,3));
        System.out.println(getHappyString(1,4));
        System.out.println(getHappyString(3,9));

    }

    public static String getHappyString(int n, int k) {
        LinkedList<String> res = new LinkedList<>();
        char[] abc = {'a', 'b', 'c'};
        dfs(abc, n, k, new StringBuilder(), res);
        return res.size() >= k ? res.get(k - 1) : "";
    }

    private static boolean dfs(char[] abc, int n, int k, StringBuilder paths, LinkedList<String> res) {
        if (paths.length() == n) {
            res.add(paths.toString());
            return res.size() == k;
        }
        for (int i = 0; i < abc.length; i++) {
            char alpa = abc[i];
            if (paths.length() == 0|| paths.charAt(paths.length() - 1) != alpa) {
                paths.append(alpa);
                boolean find = dfs(abc, n, k, paths, res);
                if (find) {
                    return true;
                }
                paths.deleteCharAt(paths.length() - 1);
            }
        }
        return false;
    }
}
