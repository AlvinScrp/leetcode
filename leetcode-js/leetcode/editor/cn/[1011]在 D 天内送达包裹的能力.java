class A1011 {

    public static void main(String[] args) {
        // System.out.println(new A1011().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int n = weights.length;
            int[] sums = new int[n];
            sums[0] = weights[0];
            int max = weights[0];
            for (int i = 1; i < n; i++) {
                sums[i] = sums[i - 1] + weights[i];
                max = Math.max(max, sums[i]);
            }
            int from = max;
            int to = sums[n - 1];
            while (from < to) {
                int mid = from + (to - from) / 2;
                if (isValueOk(mid, sums, days)) {
                    to = mid;
                } else {
                    from = mid + 1;
                }
            }
            return from;

        }

        public boolean isValueOk(int value, int[] sums, int days) {
            int count = 1;
            for (int i = 0, j = -1; i < sums.length; i++) {
                if (sums[i] - (j < 0 ? 0 : sums[j]) > value) {
                    count++;
                    j = i - 1;
                }
            }
            return count <= days;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







