package leetcode_contest.weekly_284;

import java.util.ArrayList;
import java.util.List;

public class P6031 {

    public static void main(String[] args) {
        List<Integer> ans = new P6031().new Solution().findKDistantIndices(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1);
        for (Integer an : ans) {
            System.out.print(an + ",");
        }
    }

    class Solution {
        public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
            boolean[] flag = new boolean[nums.length];
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == key) {
                    for (int i = j - k; i <= j + k; i++) {
                        if (i >= 0 && i < nums.length && !flag[i]) flag[i] = true;
                    }
                }
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < flag.length; i++) {
                if (flag[i]) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
}
