package leetcode_contest.weekly_199;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1 {

    public static void main(String[] args) {

        System.out.println();
    }

    public String restoreString(String s, int[] indices) {

        if (s == null || s.length() == 0 || s.length() != indices.length) return "";

        int n = s.length();

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> indices[o]));
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(s.charAt(queue.poll()));
        }
        return sb.toString();

    }


}
