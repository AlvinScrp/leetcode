class A440 {

    public static void main(String[] args) {
        // System.out.println(new A440().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthNumber(int n, int k) {

            long cur = 1;

            while (k > 1) {
                long count = count(cur, n);
                if (count < k) {
                    k -= count;
                    cur++;
                } else {
                    k--;
                    cur *= 10;
                }
            }
            return (int) cur;

        }

        public long count(long cur, int n) {
            long next = cur + 1;
            long count = 0;
            while (cur <= n) {
                count += Math.min(next - cur, n - cur + 1);
                cur *= 10;
                next *= 10;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







