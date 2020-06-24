package leetcode.p1_100;

import java.util.ArrayList;
import java.util.List;

public class P54 {


    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int l = 0, r = n - 1, t = 0, b = m - 1;
        int k = 0;
        while (true) {
            for (int j = l; j <= r; j++) res.add(matrix[t][j]);

            if (++t > b) break;
            for (int i = t; i <= b; i++) res.add(matrix[i][r]);

            if (l > --r) break;
            for (int j = r; j >= l; j--) res.add(matrix[b][j]);

            if (t > --b) break;
            for (int i = b; i >= t; i--) res.add(matrix[i][l]);

            if (++l > r) break;
        }
        return res;


    }
}
