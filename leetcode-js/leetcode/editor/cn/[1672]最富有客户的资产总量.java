class A1672 {

    public static void main(String[] args) {
        // System.out.println(new A1672().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumWealth(int[][] accounts) {
            int max = 0;
            for (int[] account : accounts) {
                int sum = 0;
                for (int i : account) sum += i;
                max = Math.max(sum, max);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







