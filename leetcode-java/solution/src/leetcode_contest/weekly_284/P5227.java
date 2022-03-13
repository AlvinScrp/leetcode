package leetcode_contest.weekly_284;

public class P5227 {

    public static void main(String[] args) {
//        System.out.println(new P5227().new Solution().maximumTop(new int[]{3, 2, 1}, 1));
        System.out.println(new P5227().new Solution().maximumTop(
                new int[]{91, 98, 17, 79, 15, 55, 47, 86, 4, 5, 17, 79, 68, 60, 60, 31, 72, 85, 25, 77, 8, 78, 40, 96, 76, 69, 95, 2, 42, 87, 48, 72, 45, 25, 40, 60, 21, 91, 32, 79, 2, 87, 80, 97, 82, 94, 69, 43, 18, 19, 21, 36, 44, 81, 99},
                2));

    }

    class Solution {
        public int maximumTop(int[] nums, int k) {
            if (nums.length == 1 && (k % 2) == 1) return -1;
            int max = nums[0];
            int index = 0;
            for (int i = 1; i < nums.length && i <= k; i++) {
                if (nums[i] >= max) {
                    max = nums[i];
                    index = i;
                }
            }
//            if ((k - index) % 2 == 0 || index < k - 1) {
            if (index != k - 1) {
                return nums[index];
            }

            int second = -1;
            //查找第二大的元素
            for (int i = 0; i < nums.length && i <= k; i++) {
                if (i == index) continue;
                second = Math.max(second, nums[i]);
            }
            return second;


        }
    }
}
