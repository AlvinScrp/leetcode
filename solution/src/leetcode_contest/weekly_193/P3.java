package leetcode_contest.weekly_193;

import java.util.*;

public class P3 {

    public static void main(String[] args) {
        System.out.println();
//        System.out.println(new P3().minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        System.out.println(new P3().minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
        System.out.println(new P3().minDays(new int[]{30,49,11,66,54,22,2,57,35}, 3, 3));

    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) return -1;
        int l = 0, r = Integer.MAX_VALUE;
        for (int bloom : bloomDay) {
            l = Math.min(l, bloom);
            r = Math.max(r, bloom);
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            int total = getTotal(bloomDay, mid, k);
            if (total >= m) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int getTotal(int[] bloomDay, int mid, int k) {
        int count = 0, total = 0;
        for (int bloom : bloomDay) {
            if (bloom > mid) {
                count = 0;
            } else {
                count++;
                if (count == k) {
                    total++;
                    count = 0;
                }
            }
        }
        return total;
    }


}
