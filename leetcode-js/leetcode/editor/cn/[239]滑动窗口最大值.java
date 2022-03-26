import java.util.ArrayDeque;

class A239 {

    public static void main(String[] args) {
        int[] ans = new A239().new Solution()
                .maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
//                .maxSlidingWindow(new int[]{7, 2, 4}, 2);
        for (int an : ans) {
            System.out.print(an + ",");
        }
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (k == 1) return nums;
//            PriorityQueue<Integer> p = new PriorityQueue<>(Comparator.comparingInt(o -> -nums[o]));

            ArrayDeque<Integer> q = new ArrayDeque<>();
            int[] ans = new int[nums.length - k + 1];
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (!q.isEmpty() && i - q.getFirst() + 1 > k) {
                    q.removeFirst();
                }
                while (!q.isEmpty() && nums[i] >= nums[q.getLast()]) {
                    q.removeLast();
                }
                q.addLast(i);
                if (i >= k - 1) {
                    ans[count++] = nums[q.getFirst()];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







