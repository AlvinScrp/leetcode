package leetcode.p1_100;

import java.util.*;

public class P39_combinationSum {

    public static void main(String[] args) {
        List<List<Integer>> results = combinationSum(new int[]{2, 3, 5}, 7);
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }

//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        if (candidates.length == 0) {
//            return new ArrayList<>();
//        }
//        Map<Integer, List<List<Integer>>> map = new HashMap<>();
//        Arrays.sort(candidates);
//        int length = candidates.length;
//        for (int value = candidates[0]; value <= target; value++) {
//            List<List<Integer>> results = new ArrayList<>();
//            for (int j = 0; j < length; j++) {
//                int diff = value - candidates[j];
//                if (diff == 0) {
//                    results.add(Arrays.asList(candidates[j]));
//                    continue;
//                }
//                List<List<Integer>> sources = map.get(diff);
//                if (sources != null && sources.size() > 0) {
//                    for (List<Integer> source : sources) {
//                        List<Integer> result = new ArrayList<>(source);
//                        result.add(candidates[j]);
//                        results.add(result);
//                    }
//                }
//            }
//            map.put(value, results);
//
//        }
//        List<List<Integer>> results = map.get(target);
//        results = sortAndRemoveDuplicate(results);
//        return results;
//
//
//    }
//
//    private static List<List<Integer>> sortAndRemoveDuplicate(List<List<Integer>> sources) {
//        if (sources == null || sources.isEmpty()) {
//            return new ArrayList<>();
//        }
//        List<List<Integer>> results = new ArrayList<>();
//        for (List<Integer> source : sources) {
//            Collections.sort(source);
//            if (!results.contains(source)) {
//                results.add(source);
//            }
//        }
//        return results;
//
//    }

    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的数字可以无限制重复被选取。
     * <p>
     * 说明：
     * <p>
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1:
     * <p>
     * 输入: candidates = [2,3,6,7], target = 7,
     * 所求解集为:
     * [
     * [7],
     * [2,2,3]
     * ]
     * 示例 2:
     * <p>
     * 输入: candidates = [2,3,5], target = 8,
     * 所求解集为:
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new LinkedList<>(), res);
        return res;
    }

    private static void dfs(int[] candidates, int target, int start, LinkedList<Integer> path, List<List<Integer>> res) {

        if (target == 0) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            }
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, path, res);
            path.removeLast();
        }
    }
}
