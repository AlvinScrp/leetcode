package leetcode_jianzhioffer;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

public class J59_1 {

    /**
     * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     * <p>
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new J59_1().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }


    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        ArrayDeque<Integer> deq = new ArrayDeque<>();

        int[] output = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (!deq.isEmpty() && deq.getFirst() < i - k + 1) {
                deq.removeFirst();
            }
            while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
                deq.removeLast();
            }
            deq.addLast(i);
            if (i - k + 1 >= 0) {
                output[i - k + 1] = nums[deq.getFirst()];
            }
        }
        return output;
    }


}
