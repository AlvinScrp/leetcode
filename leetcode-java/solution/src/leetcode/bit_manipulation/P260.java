package leetcode.bit_manipulation;

import java.util.Arrays;

public class P260 {
//    给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P260().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }

    public int[] singleNumber(int[] nums) {
        int flag = 0;
        for (int num : nums) flag ^= num;
        int mask = flag & (-flag);
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & mask) > 0) a ^= num;
            else b ^= num;
        }
        return new int[]{a, b};
    }
}
