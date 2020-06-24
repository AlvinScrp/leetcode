package leetcode_contest.weekly_193;

public class P1 {

    public static void main(String[] args) {
        System.out.println();

    }

    public int[] runningSum(int[] nums) {

        int[] sums = new int[nums.length];
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sums[i] = sum = sum + nums[i];
        }
        return sums;
    }


}
