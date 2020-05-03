package leetcode_contest.biweekly_25;

import java.util.ArrayList;
import java.util.List;

public class P1_5384 {

    public static void main(String[] args) {

    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> res = new ArrayList<>();
        if (candies == null || candies.length == 0) {
            return res;
        }
        int max = findMax(candies);
        for (int candy : candies) {
            res.add(candy + extraCandies >= max);
        }
        return res;

    }

    private int findMax(int[] candies) {
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        return max;
    }
}
