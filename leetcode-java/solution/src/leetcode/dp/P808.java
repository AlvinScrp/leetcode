package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class P808 {

    public static void main(String[] args) {
//        System.out.println(new P808().soupServings(660295675));
        System.out.println(new P808().soupServings(5000));
//        System.out.println(new P808().soupServings(200));
    }

    Map<Long, Double> dp = new HashMap<>();

    public double soupServings(int N) {

        if(N>=8000) return 1.0d;

        int[][] selections = new int[][]{{100, 0}, {75, 25}, {50, 50}, {25, 75}};
        double count = dfs(N, N, selections);
        return count;

    }

    private double dfs(int a, int b, int[][] selections) {


        if (a <= 0 && b > 0) return 1;
        if (a <= 0 && b <= 0) return 0.5;
        if (b <= 0) return 0;

        long key = a * 1000000000l + b;
        System.out.println(key);
        if (dp.containsKey(key)) return dp.get(key);


        double count = 0.0d;
        for (int[] selection : selections) {
            count += dfs(a - selection[0], b - selection[1], selections);
        }
        count = count * 0.25d;
        dp.put(key, count);
        return dp.get(key);

    }
}
