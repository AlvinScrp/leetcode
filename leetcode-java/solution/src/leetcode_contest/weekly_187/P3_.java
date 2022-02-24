package leetcode_contest.weekly_187;

public class P3_ {

    public static void main(String[] args) {
        System.out.println(new P3_().longestSubarray(new int[]{8}, 10));
//        System.out.println(new P3_5398().longestSubarray(new int[]{8,2,4,7},4));
//        System.out.println(new P3_5398().longestSubarray(new int[]{10,1,2,4,7,2},5));
//        System.out.println(new P3_5398().longestSubarray(new int[]{4,2,2,2,4,4,2,2},0));


    }

    public int longestSubarray(int[] nums, int limit) {
        if (nums.length <= 1) {
            return nums.length;
        }
        boolean check = check(nums, limit);
        if (check) {
            return nums.length;
        }

        int maxlenth = Math.abs(nums[0] - nums[1]) <= limit ? 2 : 0;
        for (int i = 2; i < nums.length; i++) {
            int max = nums[i], min = nums[i];
            int j;
            for (j = i; j >= 0; j--) {
                max = Math.max(nums[j], max);
                min = Math.min(nums[j], min);
                if (max - min > limit) {
                    break;
                }
            }
            int length = i - j;
            maxlenth = Math.max(maxlenth, length);
        }
        return maxlenth;

    }

    private boolean check(int[] nums, int limit) {
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return max - min <= limit;
    }
}
