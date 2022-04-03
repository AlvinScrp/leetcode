class A53 {

    public static void main(String[] args) {
        // System.out.println(new A53().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = -10001, sum = 0;
            for (int num : nums) {
                sum = Math.max(num, num + sum);
                max = Math.max(max, sum);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







