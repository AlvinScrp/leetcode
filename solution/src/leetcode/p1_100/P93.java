package leetcode.p1_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P93 {

    public static void main(String[] args) {
        System.out.println(new P93().restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, new LinkedList<>(), res);
        return res;
    }

    private void backtrack(String s, int i, LinkedList<String> path, List<String> res) {
        if (path.size() == 3) {
            String last = s.substring(i);
            if (valid(last)) {
                StringBuilder sb = new StringBuilder();
                for (String p : path) sb.append(p + ":");
                sb.append(last);
                res.add(sb.toString());
            }
            return;
        }

        for (int k = 1; k <= 3 && k + i < s.length(); k++) {
            String s1 = s.substring(i, i + k);
            if (!valid(s1)) continue;
            path.add(s1);
            backtrack(s, i + k, path, res);
            path.removeLast();
        }
    }

    private boolean valid(String str) {
        if (str.length() <= 0 || str.length() > 3) return false;
        if (str.length() >= 2 && str.startsWith("0")) return false;
        if (Integer.parseInt(str) > 255) return false;
        return true;
    }
}
