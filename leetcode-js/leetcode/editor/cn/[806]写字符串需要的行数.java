class A806 {

    public static void main(String[] args) {
        // System.out.println(new A806().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] numberOfLines(int[] widths, String s) {

            int r = 0;
            int c = 0;
            for (int i = 0; i < s.length(); i++) {
                int count = widths[s.charAt(i) - 'a'];
                if (count + c <= 100) {
                    c += count;
                } else {
                    r++;
                    c = count;
                }

            }
            if (c > 0) r++;
            return new int[]{r, c};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







