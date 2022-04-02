import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

class A85 {

    public static void main(String[] args) {
        ConcurrentHashMap map;
        HashMap hashMap;
        // System.out.println(new A85().new Solution());
        System.out.println(tableSizeFor(6));
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int maximalRectangle(char[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] heights = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    heights[i][j] = matrix[i][j] == '0' ? 0
                            : (i == 0 ? 1 : (heights[i - 1][j] + 1));
                }
            }
            int ans = 0;

            for (int i = 0; i < m; i++) {
                Stack<Integer> s = new Stack<>();
                for (int j = 0; j <= n; j++) {
                    int h = j < n ? heights[i][j] : 0;
                    while (!s.isEmpty() && heights[i][s.peek()] > h) {
                        int k = s.pop();
                        int l = s.isEmpty() ? -1 : s.peek();
                        int r = j;
                        ans = Math.max(ans, (r - l - 1) * heights[i][k]);
                    }
                    s.push(j);
                }
            }

            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







