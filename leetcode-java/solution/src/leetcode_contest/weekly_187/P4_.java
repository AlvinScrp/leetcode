package leetcode_contest.weekly_187;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class P4_ {

    public static void main(String[] args) {
        System.out.println(new P4_().kthSmallest(new int[][]{{1, 3, 11}, {2, 4, 6}}, 9));

    }

    public int kthSmallest(int[][] mat, int k) {
        List<Integer> sums = new LinkedList<>();
        for (int i = 0; i < mat[0].length && i < k; i++) {
            sums.add(mat[0][i]);
        }
        for (int i = 1; i < mat.length; i++) {
            List<Integer> list = new LinkedList<>();
            int[] ns = mat[i];
            for (int num : ns) {
                for (int oldSum : sums) {
                    list.add(num + oldSum);
                }
            }
            Collections.sort(list);
            sums = list;
            if (sums.size() > k) {
                sums = list.subList(0, k);
            }
        }
        if (k > sums.size()) {
            return 0;
        }
        return sums.get(k - 1);
    }
}
