package leetcode.dp;

import java.util.*;

public class P1349 {

    public static void main(String[] args) {


//        System.out.println(new P1349().maxStudents(new char[][]{
//                {'#', '.', '.', '.', '#'},
//                {'.', '#', '.', '#', '.'},
//                {'.', '.', '#', '.', '.'},
//                {'.', '#', '.', '#', '.'},
//                {'#', '.', '.', '.', '#'}}
//        ));
//
//        System.out.println(new P1349().maxStudents(new char[][]{
//                {'#','.','#'},
//                {'#','#','.'},
//                {'.','#','.'}
//        }
//        ));
//
//        System.out.println(new P1349().maxStudents(new char[][]{
//                        {'#', '#', '#', '#', '#', '#', '#'},
//                        {'.', '#', '.', '#', '#', '#', '#'},
//                        {'#', '#', '.', '#', '#', '.', '#'},
//                        {'#', '#', '.', '#', '#', '#', '#'},
//                        {'.', '#', '.', '#', '#', '.', '#'}
//                }
//        ));
//
//        System.out.println(new P1349().maxStudents(new char[][]{
//                        {'.', '.', '#', '#', '.', '#', '#'},
//                        {'#', '#', '#', '.', '#', '#', '.'},
//                        {'.', '#', '.', '#', '.', '#', '.'},
//                        {'.', '#', '.', '#', '.', '.', '#'},
//                        {'.', '.', '#', '#', '.', '#', '.'},
//                        {'#', '.', '#', '#', '.', '#', '#'}
//                }
//        ));


        System.out.println(new P1349().maxStudents(new char[][]{
                {'#', '.', '#', '#', '.', '#'},
                {'.', '#', '#', '#', '#', '.'},
                {'#', '.', '#', '#', '.', '#'}}
        ));


    }


    public int maxStudents(char[][] seats) {
        int m = seats.length, n = seats[0].length;
        int N = 1 << n;
        int[][] dp = new int[m][N];
        for (int i = 0; i < m; i++) {
            for (int chosen = 0; chosen < N; chosen++) {
                //这个数字自身是否合法
                boolean isValid = true;
                for (int j = 0; j < n; j++) {
                    if (isSited(chosen, j, n)){
                        if (seats[i][j] == '#' || (j > 0 && (chosen & (1 << (j - 1))) > 0)) {
                            isValid = false;
                            break;
                        }
                    }
                }
                if (!isValid) continue;

                int chosenCount = 0;
                for (int j = 0; j < n; j++) {
                    if (isSited(chosen, j, n)) chosenCount++;
                }
                if (i == 0) {
                    dp[i][chosen] = chosenCount;
                    continue;
                }

                for (int preChosen = 0; preChosen < N; preChosen++) {
                    boolean isOk = true;
                    for (int j = 0; j < n; j++) {
                        if (isSited(chosen, j, n)
                                && (isSited(preChosen, j - 1, n) || isSited(preChosen, j + 1, n))) {
                            isOk = false;
                            break;
                        }
                    }
                    if (isOk) {
                        dp[i][chosen] = Math.max(dp[i][chosen], chosenCount + dp[i - 1][preChosen]);
                    }
                }
            }

        }

        int ans = 0;
        for (int j = 0; j < N; j++) {
            ans = Math.max(ans, dp[m - 1][j]);
        }
        return ans;

    }

    private boolean isSited(int chosen, int j, int n) {
        return j >= 0 && j < n && (chosen & (1 << j)) > 0;
    }


}
