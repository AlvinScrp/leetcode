package leetcode.p1_100;

import java.util.HashMap;

public class P1_TwoSum {

    public static int[] nums = new int[]{2, 7, 11, 15};

    public static int target = 9;

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) { //不能和自身相加
            if (map.containsKey(target - nums[i])) {
                if (i == (int) map.get(target - nums[i])) {
                    continue;
                }
                int[] res = {i, (int) map.get(target - nums[i])};
                return res;
            }
        }
        int[] res = {-1, -1};
        return res;

    }
}
