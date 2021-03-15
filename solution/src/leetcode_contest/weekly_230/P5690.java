package leetcode_contest.weekly_230;

public class P5690 {


    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        if (baseCosts == null || baseCosts.length == 0) return 0;

        int min = baseCosts[0], max = baseCosts[0];
        for (int baseCost : baseCosts) {
            min = Math.min(baseCost, min);
            max = Math.max(baseCost, max);
        }
        low = min;

        for (int baseCost : baseCosts) {
            bfs(baseCost, 0, toppingCosts, target);
        }


        if (result != -1) {
            return result;
        } else if (target - low > high - target) {
            return high;
        } else {
            return low;
        }

    }

    int result = -1;
    int low = Integer.MIN_VALUE;
    int high = Integer.MAX_VALUE;

    private void bfs(int cost, int j, int[] toppingCosts, int target) {


        if (cost == target) {
            result = cost;
            return;
        } else if (cost > target) {
            if (high > cost) {
                high = cost;
            }
        } else if (cost < target) {
            if (low < cost) {
                low = cost;
            }
        }
        if (result == target) return;

        if (j == toppingCosts.length) return;
        if (cost > target) return;

        for (int count = 0; count < 3; count++) {
//            int newCost=cost + toppingCosts[j] * count;
            bfs(cost + toppingCosts[j] * count, j + 1, toppingCosts, target);
        }

    }
}
