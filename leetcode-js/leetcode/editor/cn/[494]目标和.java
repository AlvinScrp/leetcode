class A494 {

    public static void main(String[] args) {
        // System.out.println(new A494().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][][] cache;

        public int findTargetSumWays(int[] nums, int target) {

            cache = new int[nums.length][1001][2];
            return dfs(nums, target, 0, 0);

        }

        private int dfs(int[] nums, int target, int i, int value) {

            if (i == nums.length) return value == target ? 1 : 0;
            int j = Math.abs(value), k = value > 0 ? 0 : 1;
            if (cache[i][j][k] > 0)
                return cache[i][j][k];

            int count = dfs(nums, target, i + 1, value + nums[i])
                    + dfs(nums, target, i + 1, value - nums[i]);
            cache[i][j][k] = count;

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







