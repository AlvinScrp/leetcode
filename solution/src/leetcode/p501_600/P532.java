package leetcode.p501_600;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P532 {

    public static void main(String[] args) {
        System.out.println(new P532().findPairs(new int[]{3, 1, 4, 1, 5}, 2));
    }

    public int findPairs(int[] nums, int k) {

        Set<Integer> res = new HashSet<>();
        Set<Integer> cache = new HashSet<>();
        Arrays.sort(nums);

        if (k == 0) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1]) res.add(nums[i]);
            }
        }else {
            for (int num : nums) {
                cache.add(num);
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                if (cache.contains(nums[i] - k)) res.add(nums[i]);
            }
        }
        return res.size();

    }
}
