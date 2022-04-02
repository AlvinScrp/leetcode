import java.util.Stack;

class A84 {

    public static void main(String[] args) {
        // System.out.println(new A84().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {

            Stack<Integer> s = new Stack<>();
            int ans = 0;
            int[] hs = new int[heights.length + 2];
            for (int i = 0; i < heights.length; i++) {
                hs[i + 1] = heights[i];
            }
            s.push(0);
            for (int i = 1; i < hs.length; i++) {
                while (hs[s.peek()] > hs[i]) {
                    int h = hs[s.pop()];
                    int left = s.peek();
                    int right = i;
                    ans = Math.max(ans, (right - left - 1) * h);
                }
                s.push(i);
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







