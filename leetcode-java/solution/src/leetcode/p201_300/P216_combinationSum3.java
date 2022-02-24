package leetcode.p201_300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P216_combinationSum3 {

    public static void main(String[] args) {
       combinationSum3(3, 7).stream().forEach(System.out::println);
       combinationSum3(3, 9).stream().forEach(System.out::println);

    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 1, new LinkedList<Integer>(), res);
        return res;
    }

    /**
     * @param target 目标值
     * @param k      k个数字
     * @param start  1-9，从某个数字开始
     * @param paths  当前路径
     * @param res    结果列表
     */
    private static void dfs(int target, int k, int start, LinkedList<Integer> paths, List<List<Integer>> res) {
        if (paths.size() == k) {
            if (target == 0) {
                res.add(new ArrayList<>(paths));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (target < i) {
                break;
            }
            paths.add(i);
            dfs(target - i, k, i + 1, paths, res);
            paths.removeLast();

        }
    }
    /**
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     *
     * 说明：
     *
     * 所有数字都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1:
     *
     * 输入: k = 3, n = 7
     * 输出: [[1,2,4]]
     * 示例 2:
     *
     * 输入: k = 3, n = 9
     * 输出: [[1,2,6], [1,3,5], [2,3,4]]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

}
