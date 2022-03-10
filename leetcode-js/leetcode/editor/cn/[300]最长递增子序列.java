class A300 {

    public static void main(String[] args) {
        //new A300().new Solution()
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            if (n <= 1) return n;
            int[] tails = new int[n];//dp[i]表示长度为i+1的序列的末尾元素最小值
            int k = 0;
            tails[k] = nums[0];

            for (int i = 1; i < n; i++) {
                if (nums[i] > tails[k]) {
                    tails[++k] = nums[i];
                } else {
                    int j = binSearch(tails, 0, k, nums[i]);
                    tails[j] = nums[i];
                }
            }
            return k + 1;
        }

        //找到tails中，所有>=target的元素的最小值的下标
        private int binSearch(int[] tails, int lo, int hi, int target) {
            if (lo >= hi) return lo;
            int mid = lo + (hi - lo) / 2;
            if (tails[mid] < target) return binSearch(tails, mid + 1, hi, target);
            else return binSearch(tails, lo, mid, target);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







