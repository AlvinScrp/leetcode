package leetcode_mianshi;

public class P3 {

    public static void main(String[] args) {
        System.out.println();
    }

    public int findRepeatNumber(int[] nums) {
        int length = nums.length;
        boolean[] flags = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (flags[nums[i]] == true) {
                return nums[i];
            }
            flags[nums[i]] = true;
        }
        return -1;

    }
}
