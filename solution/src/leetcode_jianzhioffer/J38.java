package leetcode_jianzhioffer;

import java.util.HashSet;
import java.util.Set;

public class J38 {
    public static void main(String[] args) {
        new J38().permutation("abc");
    }

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) return new String[0];
        if (s.length() == 1) return new String[]{s};

        char[] chars = s.toCharArray();
        boolean[] flag = new boolean[chars.length];
        Set<String> set = new HashSet<>();
        dfs(chars, 0, flag, set, new StringBuilder());
        String[] res = new String[set.size()];
        set.toArray(res);
        return res;

    }

    private void dfs(char[] chars, int count, boolean[] flag, Set<String> set, StringBuilder sb) {

        if (count == chars.length) {
            set.add(sb.toString());
            return;
        }
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (!flag[i] && !charSet.contains(chars[i])) {
                flag[i] = true;
                charSet.add(chars[i]);
                sb.append(chars[i]);
                dfs(chars, count + 1, flag, set, sb);
                sb.deleteCharAt(sb.length() - 1);
                flag[i] = false;
            }

        }
    }
}
