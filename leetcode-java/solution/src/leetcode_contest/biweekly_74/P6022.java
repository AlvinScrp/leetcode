package leetcode_contest.biweekly_74;

import java.util.PriorityQueue;

public class P6022 {
    public static void main(String[] args) {
//        System.out.println(halveArray(new int[]{5, 19, 8, 1}));
//        System.out.println(halveArray(new int[]{1}));
        System.out.println(halveArray(new int[]{9999999, 10000000}));
    }

    public static int halveArray(int[] nums) {
        PriorityQueue<Double> q = new PriorityQueue<>((o1, o2) -> o1 == o2 ? 0 : (o1 < o2 ? 1 : -1));
        double sum = 0.0f;
        for (int num : nums) {
            q.add((double) num);
            sum += num;
        }
        sum = sum / 2.0d;
        int count = 0;
        while (sum > 0) {
            double val = q.poll() / 2.0d;
            sum -= val;
            count++;
            q.add(val);
        }
        return count;

    }
}
