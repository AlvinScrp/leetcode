package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P47_permutations_2 {

    public static void main(String[] args) {
        permuteUnique(new int[]{1, 1, 2}).stream().forEach(System.out::println);
    }


    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> numList = new ArrayList<>();
        Arrays.sort(nums);
        for (int num : nums) {
            numList.add(num);
        }
        dfs(numList, new LinkedList<>(), res);
        return res;
    }

    private static void dfs(ArrayList<Integer> nums, LinkedList<Integer> paths, List<List<Integer>> res) {
        if (nums.isEmpty()) {
            res.add(new ArrayList<>(paths));
            return;
        }
        int size = nums.size();
        for (int i = 0; i < size; i++) {
            if (i != 0 && nums.get(i) == nums.get(i - 1)) {
                continue;
            }
            ArrayList<Integer> copy = new ArrayList<>(nums);
            int num = copy.remove(i);
            paths.add(num);
            dfs(copy, paths, res);
            paths.removeLast();
        }
    }

    /**
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     *
     *         示例:
     *
     *         输入: [1,1,2]
     *         输出:
     * [
     *   [1,1,2],
     *   [1,2,1],
     *   [2,1,1]
     * ]
     *
     *         来源：力扣（LeetCode）
     *         链接：https://leetcode-cn.com/problems/permutations-ii
     *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
}
