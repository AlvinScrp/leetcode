class A498 {

    public static void main(String[] args) {
        int[] ans = new A498().new Solution().findDiagonalOrder(
                new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        for (int an : ans) {
            System.out.print(an + ",");
        }
        System.out.println();
        ans = new A498().new Solution().findDiagonalOrder(
                new int[][]{{1, 2, 3}, {4, 5, 6}});
        for (int an : ans) {
            System.out.print(an + ",");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            int[] ans = new int[m * n];
            int i = 0, j = 0, k = 0;
            ans[k++] = mat[i][j];
            boolean up = true;
            while (k < ans.length) {
                //寻找下一个元素
                if (up) {
                    if (i - 1 >= 0 && j + 1 <= n - 1) {
                        i = i - 1;
                        j = j + 1;
                    } else {
                        boolean right = i == 0 && j + 1 <= n - 1;
                        j = right ? j + 1 : j;
                        i = right ? i : i + 1;
                        up = false;
                    }
                } else {
                    if (i + 1 <= m - 1 && j - 1 >= 0) {
                        i = i + 1;
                        j = j - 1;
                    } else {
                        boolean down = i + 1 <= m - 1 && j == 0;
                        i = down ? i + 1 : i;
                        j = down ? j : j + 1;
                        up = true;
                    }

                }
                ans[k++] = mat[i][j];
            }
            return ans;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







