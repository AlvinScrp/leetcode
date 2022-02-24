package leetcode_contest.weekly_192;

public class P1 {

    public static void main(String[] args) {
        System.out.println(new P1());
    }

    public int[] shuffle(int[] nums, int n) {

        int[] ans = new int[n * 2];

        for (int i = 0, j = 0; i < n; i++) {
            ans[j++] = nums[i];
            ans[j++] = nums[i + n];
        }
        return ans;
    }
}
