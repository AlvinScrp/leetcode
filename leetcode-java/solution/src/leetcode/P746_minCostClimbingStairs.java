package leetcode;

public class P746_minCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost1 = {10, 15, 20};
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost1));
        System.out.println(minCostClimbingStairs(cost2));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        int minCost0 = cost[0];
        int minCost1 = cost[1];
        int temp;
        for (int i = 2; i < n + 1; i++) {
            temp = Math.min(minCost0 + cost[i - 2], minCost1 + cost[i - 1]);
            minCost0 = minCost1;
            minCost1 = temp;
        }
        return minCost1;
    }
}

