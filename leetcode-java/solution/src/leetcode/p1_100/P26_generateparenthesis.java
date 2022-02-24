package leetcode.p1_100;

import java.util.*;

public class P26_generateparenthesis {

    public static void main(String[] args) {
        generateParenthesis(3).stream().forEach(System.out::println);

    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n>0) {
            StringBuilder paths = new StringBuilder();
            dfs(n, 0, 0, paths, res);
        }
        return  res;

    }

    private static void dfs(int n,int left, int right, StringBuilder paths, List<String> res) {
        if (left + right == n << 1) {
            res.add(paths.toString());
            return;
        }
        if (left < n) {
            paths.append('(');
            dfs(n, left + 1, right, paths, res);
            paths.deleteCharAt(paths.length() - 1);
        }
        if (right < n && left > right) {
            paths.append(')');
            dfs(n, left, right + 1, paths, res);
            paths.deleteCharAt(paths.length() - 1);
        }

    }

}

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */