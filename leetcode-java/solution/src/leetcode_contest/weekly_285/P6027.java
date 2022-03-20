package leetcode_contest.weekly_285;

public class P6027 {

    public static void main(String[] args) {
        System.out.println(countHillValley(new int[]{2, 4, 1, 1, 6, 5}));
        System.out.println(countHillValley(new int[]{6, 6, 5, 5, 4, 1}));

    }

    public static int countHillValley(int[] nums) {

        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int j = i - 1, k = i + 1;
            if (nums[i] == nums[i - 1]) continue;

            while (j >= 0) {
                if (nums[j] == nums[i]) j--;
                else break;
            }
            while (k < nums.length) {
                if (nums[k] == nums[i]) k++;
                else break;
            }
            if (j >= 0 && k < nums.length) {
                if (nums[j] < nums[i] && nums[k] < nums[i]) {
                    count++;
                } else if (nums[j] > nums[i] && nums[k] > nums[i]) {
                    count++;
                }
            }

        }
        return count;

    }


}
