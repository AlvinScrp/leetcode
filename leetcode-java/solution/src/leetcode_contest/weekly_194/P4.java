package leetcode_contest.weekly_194;

import java.util.Arrays;

public class P4 {

    public static void main(String[] args) {
        System.out.println();

//        TreeAncestor treeAncestor=new TreeAncestor(7,new int[]{-1,0,0,1,1,2,2});
        int[] parent = new int[50002];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i - 1;
        }
        TreeAncestor treeAncestor = new TreeAncestor(parent.length, parent);
        System.out.println(treeAncestor.getKthAncestor(50000, 5));
//        System.out.println(treeAncestor.getKthAncestor(9, 9));
//        System.out.println(treeAncestor.getKthAncestor(9, 11));
//        System.out.println(treeAncestor.getKthAncestor(5, 2));
//        System.out.println(treeAncestor.getKthAncestor(6, 3));

    }

    static class TreeAncestor {

        int[][] dp;
        int m = 17;

        public TreeAncestor(int n, int[] parent) {


            dp = new int[n][m];
            for (int[] ints : dp) {
                Arrays.fill(ints, -1);
            }

            for (int i = 0; i < n; i++) {
                dp[i][0] = parent[i];
            }
            for (int j = 1; j < m; j++) {
                boolean allRooted = true;
                for (int i = 1; i < n; i++) {
                    dp[i][j] = dp[i][j - 1] == -1 ? -1 : dp[dp[i][j - 1]][j - 1];
                    if (dp[i][j] != -1) allRooted = false;
                }
                if (allRooted) break;
            }
//            for (int[] ints : dp) {
//                System.out.println(Arrays.toString(ints));
//            }
        }

        public int getKthAncestor(int node, int k) {

            for (int j = m; j >= 0; j--) {
                if ((k & (1 << j)) != 0) {
                    k -= (1 << j);
                    node = dp[node][j];
                    if (node == -1) break;
                }

            }
            return node;

        }
    }


}
