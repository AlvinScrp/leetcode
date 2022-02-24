package leetcode_jianzhioffer;

import java.util.Arrays;

public class J56_1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new J56_1().singleNumbers(new int[]{4, 4, 1, 6})));
    }

    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int num : nums) sum ^= num;
//        Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
        int mask = sum & (-sum);
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) a ^= num;
            else b ^= num;
        }
        return new int[]{a, b};
    }
}
