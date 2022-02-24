package leetcode_fuxi20201208;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pmianshi08_09 {
    public static void main(String[] args) {
        System.out.println(new Pmianshi08_09().generateParenthesis(3));

    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[] choices = new int[]{1, -1};
        dfs(0, n * 2, sb, res, choices);
        return res;
    }

    public void dfs(int sum, int leaves, StringBuilder sb, List<String> res, int[] choices) {
        if (leaves == 0) {
            if (sum == 0) res.add(sb.toString());
            return;
        }
        if (sum > leaves) return;
        for (int choice : choices) {
            if (sum + choice < 0) continue;
            sb.append(choice == 1 ? '(' : ')');
            dfs(sum + choice, leaves - 1, sb, res, choices);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
