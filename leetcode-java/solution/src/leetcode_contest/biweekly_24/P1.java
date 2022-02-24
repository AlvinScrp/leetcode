package leetcode_contest.biweekly_24;

public class P1 {

    public static void main(String[] args) {
        System.out.println(minStartValue(new int[]{-3, 2, -3, 4, 2}));

    }

    /**
     * 输入：nums = [-3,2,-3,4,2]
     * 输出：5
     * 解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
     * 累加求和
     * startValue = 4 | startValue = 5 | nums
     * (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
     * (1 +2 ) = 3  | (2 +2 ) = 4    |   2
     * (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
     * (0 +4 ) = 4  | (1 +4 ) = 5    |   4
     * (4 +2 ) = 6  | (5 +2 ) = 7    |   2
     */

    public static int minStartValue(int[] nums) {

        int length = nums.length;
        int min = 0;
        int current = 0;
        for (int i = 0; i < length; i++) {
            current = current + nums[i];
            min = Math.min(min, current);
        }
        if (min > 0) {
            return 1;
        }
        return min > 0 ? 1 : 1 - min;

    }
}
