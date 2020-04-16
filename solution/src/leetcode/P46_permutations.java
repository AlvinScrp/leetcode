package leetcode;

import com.sun.deploy.util.LinkMouseListener;

import java.util.*;

public class P46_permutations {

//    public static void main(String[] args) {
//        permute(new int[]{1, 2, 3}).stream().forEach(System.out::println);
//    }
//
//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        ArrayList<Integer> numList = new ArrayList<>();
//        for (int num : nums) {
//            numList.add(num);
//        }
//        dfs(numList, new LinkedList<>(), res);
//        return res;
//    }
//
//    private static void dfs(ArrayList<Integer> nums, LinkedList<Integer> paths, List<List<Integer>> res) {
//        if (nums.isEmpty()) {
//            res.add(new ArrayList<>(paths));
//            return;
//        }
//        int size = nums.size();
//        for (int i = 0; i < size; i++) {
//            ArrayList<Integer> copy = new ArrayList<>(nums);
//            int num = copy.remove(i);
//            paths.add(num);
//            dfs(copy, paths, res);
//            paths.removeLast();
//        }
//    }

    /**
     *  给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     *
     *         示例:
     *
     *         输入: [1,2,3]
     *         输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     *         来源：力扣（LeetCode）
     *         链接：https://leetcode-cn.com/problems/permutations
     *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *     }
     */

}
