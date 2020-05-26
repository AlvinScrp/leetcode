package leetcode.bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class P78 {

    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 说明：解集不能包含重复的子集。
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     * [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     *
     * @return
     */

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        int n = nums.length;
        int max = 0;
        int[] masks = new int[n];
        for (int mask = 1, i = 0; i < n; i++) {
            masks[i] = mask;
            max += mask;
            mask = mask << 1;

        }
        for (int i = 0; i <= max; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((masks[j] & i) > 0) list.add(nums[j]);
            }
            res.add(list);
        }
        return res;

    }
}
