class A55 {

    public static void main(String[] args) {
        // System.out.println(new A55().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {

            int n = nums.length;
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (i > max) break;
                max = Math.max(max, i + nums[i]);
                if (max >= n - 1) return true;
            }
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







