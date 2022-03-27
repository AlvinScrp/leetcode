package leetcode_contest.weekly_286;

public class P5236 {

    public static void main(String[] args) {
//        System.out.println(new P2().minDeletion(new int[]{1, 1, 2, 3, 5}));
        System.out.println(new P5236().minDeletion(new int[]{1, 1, 2, 2, 3, 3}));

    }

    public int minDeletion(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int j = i - count;
            if (j % 2 == 0) {
                if (nums[i] == nums[i + 1]) {
                    count++;
                }
            } else {
                continue;
            }
        }
        return count + ((n - count) % 2 == 1 ? 1 : 0);

    }


}
