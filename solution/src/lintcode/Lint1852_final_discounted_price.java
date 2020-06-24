package lintcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Lint1852_final_discounted_price {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(FinalDiscountedPrice(new int[]{2, 3, 1, 2, 4, 2})));
        System.out.println(Arrays.toString(FinalDiscountedPrice(new int[]{1, 2, 3, 4, 5})));
    }

    public static int[] FinalDiscountedPrice(int[] prices) {
        // write your code here

        int[] ans = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = prices[i];
            } else {
                ans[i] = prices[i] - prices[stack.peek()];
            }
            stack.push(i);
        }
        return ans;
    }

}
