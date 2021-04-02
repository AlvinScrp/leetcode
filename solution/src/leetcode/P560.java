package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P560 {

    public static void main(String[] args) {
        System.out.println(new P560().subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(new P560().subarraySum(new int[]{1, -1, 0}, 0));
    }

    public int subarraySum(int[] nums, int k) {

        int res = 0;
        int n = nums.length;
        int preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) {
                res += map.get(preSum - k);
            }
            if (map.containsKey(preSum)) {
                map.put(preSum, map.get(preSum) + 1);
            } else {
                map.put(preSum, 1);
            }
        }
        return res;

    }
}
