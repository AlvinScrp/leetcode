package leetcode.bit_manipulation;

public class P137 {

    public int singleNumber(int[] nums) {

        int a = 0, b = 0;
        for (int num : nums) {
            b = num ^ b & ~a;
            a = num ^ a & ~b;
        }
        return b;

    }
}
