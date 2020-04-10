package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P120_triangle {

    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(minimumTotal(triangle));

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int minValue = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> tt = triangle.get(i);
            for (int j = 0; j < tt.size(); j++) {
                List<Integer> preT = triangle.get(i - 1);
                int current = tt.get(j) + Math.min(getValue(preT, j - 1), getValue(preT, j));
                tt.set(j, current);
                minValue = j == 0 ? current : Math.min(minValue, current);
            }
        }
        return minValue;
    }

    public static int getValue(List<Integer> tt, int index) {
        if (tt == null || index < 0 || index >= tt.size()) {
            return Integer.MAX_VALUE;
        }
        return tt.get(index);
    }
}
