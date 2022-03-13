package leetcode_contest.weekly_284;

public class P5203 {

    public static void main(String[] args) {

    }

    class Solution {
        public int digArtifacts(int n, int[][] artifacts, int[][] dig) {

            boolean[][] blocks = new boolean[n][n];

            for (int[] d : dig) blocks[d[0]][d[1]] = true;
            int count = 0;

            for (int[] artifact : artifacts) {
                int r1 = artifact[0], c1 = artifact[1], r2 = artifact[2], c2 = artifact[3];
                boolean can = true;
                for (int i = r1; i <= r2; i++) {
                    for (int j = c1; j <= c2; j++) {
                        if (!blocks[i][j]) {
                            can = false;
                            break;
                        }
                    }
                }
                if (can) count++;
            }
            return count;

        }
    }
}
