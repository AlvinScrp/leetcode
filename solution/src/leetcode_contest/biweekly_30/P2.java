package leetcode_contest.biweekly_30;

import java.util.PriorityQueue;

public class P2 {

    public static void main(String[] args) {
        System.out.println(new P2().rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 5));

    }

    public int rangeSum(int[] nums, int n, int left, int right) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                queue.add(sum);
            }
        }
        int ans = 0;
        for (int i = 1; !queue.isEmpty() && i <= right; i++) {
            int val = queue.poll();
            if (i >= left) {
                ans = (ans + val) % 1000000007;
            }
        }
        return ans;
    }


}
