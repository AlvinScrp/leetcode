package leetcode_contest.weekly_231;

public class P5698 {

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0l;
        for (int num : nums) sum += num;
        long diff = Math.abs(goal - sum);
        long count = diff / limit + (diff % limit == 0 ? 0 : 1);
        return (int) count;

    }
}
