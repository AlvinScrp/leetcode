package leetcode.bit_manipulation;

import java.util.Arrays;

public class P136 {

    //a^a =0 a^0=a  a^b=b^a
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
    }
}
