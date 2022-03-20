package leetcode_contest.weekly_285;

public class P6029 {

    public static void main(String[] args) {
        int[] ans = new P6029().maximumBobPoints(9, new int[]{1, 1, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0});
        for (int i = 0; i < ans.length; i++) {
            System.out.print("," + ans[i]);
        }
        System.out.println();
        ans = new P6029().maximumBobPoints(89, new int[]{3, 2, 28, 1, 7, 1, 16, 7, 3, 13, 3, 5});
        for (int i = 0; i < ans.length; i++) {
            System.out.print("," + ans[i]);
        }
        System.out.println();

        ans = new P6029().maximumBobPoints(3, new int[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2});
        for (int i = 0; i < ans.length; i++) {
            System.out.print("," + ans[i]);
        }
        System.out.println();

    }


    int[] bobs;
    int max = 0;

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        dfs(0, 0, numArrows, new int[12], aliceArrows);
        return bobs;
    }

    private void dfs(int i, int points, int numArrows, int[] path, int[] aliceArrows) {
        if (i == 12 || numArrows <= 0) {
            if (points > max && numArrows >= 0) {
                bobs = path.clone();
                max = points;
                bobs[0] += numArrows;
            }
            return;
        }

        dfs(i + 1, points, numArrows, path, aliceArrows);
        path[i] = aliceArrows[i] + 1;
        dfs(i + 1, points + i, numArrows - path[i], path, aliceArrows);
        path[i] = 0;
    }


}
