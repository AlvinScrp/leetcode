package leetcode.p1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;




public class P90 {

    public static void main(String[] args) {
//        List<List<Integer>> res = new P90().subsetsWithDup(new int[]{1, 2, 2});
        List<List<Integer>> res = new P90().subsetsWithDup(new int[]{4, 4, 4,1, 4});
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

//    给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//    说明：解集不能包含重复的子集。
//
//    输入: [1,2,2]
//    输出:[[2],[1], [1,2,2], [2,2],[1,2],[]  ]

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(-1, nums.length - 1, nums, new LinkedList<>(), res);
        return res;
    }

    private void backtrack(int start, int n, int[] nums, LinkedList<Integer> path, List<List<Integer>> res) {

        res.add(new LinkedList<>(path));
        for (int i = start + 1; i <= n; i++) {
            if (i > start + 1 && nums[i] == nums[i - 1]) continue;
//            if (i != n && nums[i] == nums[i + 1]) continue;
            path.addLast(nums[i]);
            backtrack(i, n, nums, path, res);
            path.removeLast();
        }
    }
}
