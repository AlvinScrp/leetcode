package leetcode_contest.weekly_194;

import java.util.*;

public class P3 {

    public static void main(String[] args) {
        System.out.println();
        System.out.println(Arrays.toString(new P3().avoidFlood2(new int[]{1, 2, 0, 0, 2, 1})));
        System.out.println(Arrays.toString(new P3().avoidFlood2(new int[]{1, 2, 0, 1, 2})));
        System.out.println(Arrays.toString(new P3().avoidFlood2(new int[]{69, 0, 0, 0, 69})));
        System.out.println(Arrays.toString(new P3().avoidFlood2(new int[]{1, 0, 2, 0})));
        System.out.println(Arrays.toString(new P3().avoidFlood2(new int[]{1, 0, 2, 0, 2, 1})));
        System.out.println(Arrays.toString(new P3().avoidFlood2(new int[]{1, 2, 1, 2})));

    }

    public int[] avoidFlood(int[] rains) {
        if (rains == null || rains.length == 0) return new int[0];


        int n = rains.length;
        Map<Integer, Integer> registries = new HashMap<>(n);
        int[] next = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            next[i] = registries.getOrDefault(rains[i], n);
            registries.put(rains[i], i);
        }
//        System.out.println(Arrays.toString(next));

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        PriorityQueue<Rain> pq = new PriorityQueue<>(n, Comparator.comparingInt(a -> a.day));
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                if (!pq.isEmpty()) {
                    ans[i] = pq.remove().index;
                } else {
                    ans[i] = 1;
                }
            } else {
                pq.add(new Rain(rains[i], next[i]));

            }

            if (!pq.isEmpty() && pq.peek().day <= i) {
                return new int[0];
            }

        }
        return ans;
    }

    public int[] avoidFlood2(int[] rains) {
        if (rains == null || rains.length == 0) return new int[0];

        int n = rains.length;
        Map<Integer, Integer> registries = new HashMap<>(n);
        int[] next = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (rains[i] > 0) {
                next[i] = registries.getOrDefault(rains[i], n);
                registries.put(rains[i], i);
            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        //rain[i]的湖泊，next rain index
        PriorityQueue<Integer> nexts = new PriorityQueue<>(n, Comparator.comparingInt(o -> next[o]));
        Set<Integer> pools = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                if (!nexts.isEmpty()) {
                    ans[i] = rains[nexts.remove()];
                    pools.remove(ans[i]);
                } else {
                    ans[i] = 1;
                }
            } else {
                if (pools.contains(rains[i])) return new int[0];
                pools.add(rains[i]);
                nexts.add(i);
            }

        }
        return ans;
    }
}

class Rain {
    int index;
    int day;

    public Rain(int index, int day) {
        this.index = index;
        this.day = day;
    }
}

