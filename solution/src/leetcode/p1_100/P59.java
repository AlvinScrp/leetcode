package leetcode.p1_100;

import java.util.Arrays;

public class P59 {
//
//    输入: 3
//    输出: [
//            [ 1, 2, 3 ],
//            [ 8, 9, 4 ],
//            [ 7, 6, 5 ]
//            ]

    public static void main(String[] args) {
        generateMatrix(4);
    }



    public static int[][] generateMatrix(int n) {

        int[][] ans = new int[n][n];

        int x = 0;
        int l = 0, r = n - 1, t = 0, b = n - 1;
        while (l < r && t < b) {
            for (int j = l; j < r; j++) ans[t][j] = ++x;
            for (int i = t; i < b; i++) ans[i][r] = ++x;
            for (int j = r; j > l; j--) ans[b][j] = ++x;
            for (int i = b; i > t; i--) ans[i][l] = ++x;
            l++;
            r--;
            t++;
            b--;
        }
        if (l == r)  ans[t][r] = ++x;

//        for (int i = 0; i < ans.length; i++) {
//            System.out.println(Arrays.toString(ans[i]));
//        }

        return ans;

    }
}
