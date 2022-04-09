class A135 {

    public static void main(String[] args) {
        // System.out.println(new A135().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int sum = 1, pre = 1, inc = 1, dec = 0;
            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    dec = 0;
                    pre++;
                    inc = pre;
                    sum += pre;
                } else if (ratings[i] == ratings[i - 1]) {
                    dec = 0;
                    pre = 1;
                    inc = pre;
                    sum += pre;
                } else if (ratings[i] < ratings[i - 1]) {
                    dec++;
                    if (dec == inc) dec++;
                    sum += dec;
                    pre = 1;
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







