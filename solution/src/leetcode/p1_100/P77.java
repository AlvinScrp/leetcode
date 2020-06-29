package leetcode.p1_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P77 {

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * <p>
     * 示例:
     * <p>
     * 输入: n = 4, k = 2
     * 输出:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     *
     * @param n
     * @param k
     * @return
     */

    public static void main(String[] args) {
        List<List<Integer>> res = new P77().combine(4, 2);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, new LinkedList<>(), res);
        return res;
    }

    private void backtrack(int start, int n, int k, LinkedList<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new LinkedList<>(path));
            return;
        }
        if (n - start + 1 < k - path.size()) return;
        for (int i = start; i <= n; i++) {
            path.addLast(i);
            backtrack(i + 1, n, k, path, res);
            path.removeLast();
        }
    }
}
