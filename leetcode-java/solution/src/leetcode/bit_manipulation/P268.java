package leetcode.bit_manipulation;

public class P268 {

    public int missingNumber(int[] nums) {

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i] ^ i;
        }
        ans ^= nums.length;
        return ans;

    }
}
