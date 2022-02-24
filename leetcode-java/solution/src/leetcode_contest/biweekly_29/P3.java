package leetcode_contest.biweekly_29;

import java.util.ArrayList;
import java.util.List;

public class P3 {

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        System.out.println(longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println(longestSubarray(new int[]{1, 1, 1}));

    }

    public static int longestSubarray(int[] nums) {
//        int i =1816214400;
        List<Integer> zeros = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeros.add(i);
        }

        if (zeros.isEmpty()) return nums.length - 1;
        if (zeros.get(0) != 0) zeros.add(0, -1);
        if (zeros.get(zeros.size() - 1) != nums.length - 1) zeros.add(nums.length);

        int max = 0;

        for (int i = 1; i < zeros.size() - 1; i++) {
            int value = zeros.get(i + 1) - zeros.get(i - 1) - 2;
            max = Math.max(max, value);
        }
        return max;
    }


}
