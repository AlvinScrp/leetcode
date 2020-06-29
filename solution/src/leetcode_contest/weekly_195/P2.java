package leetcode_contest.weekly_195;

public class P2 {

    public static void main(String[] args) {
        System.out.println(canArrange(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5));
        System.out.println(canArrange(new int[]{-1, 1, -2, 2, -3, 3, -4, 4}, 3));

    }


    /**
     * 输入：arr = [1,2,3,4,5,10,6,7,8,9], k = 5
     * 输出：true
     * 解释：划分后的数字对为 (1,9),(2,8),(3,7),(4,6) 以及 (5,10) 。
     * <p>
     * 给你一个整数数组 arr 和一个整数 k ，其中数组长度是偶数，值为 n 。
     * 现在需要把数组恰好分成 n / 2 对，以使每对数字的和都能够被 k 整除。
     * 如果存在这样的分法，请返回 True ；否则，返回 False 。
     *
     * @param arr
     * @param k
     * @return
     */
    public static boolean canArrange(int[] arr, int k) {

        if (arr.length == 2) return (arr[0] + arr[1]) % k == 0;


        int[] nums = new int[k];
        for (int i : arr) {
            int j = i % k;
            if (j < 0) j += k;
            nums[j]++;
        }
        if (nums[0] % 2 != 0) return false;
        if (k % 2 == 0) {
            if (nums[k / 2] % 2 != 0) return false;
        }

        for (int i = 1; i <= (k - 1) / 2; i++) {
            if (nums[i] != nums[k - i]) return false;
        }
        return true;

    }


}
