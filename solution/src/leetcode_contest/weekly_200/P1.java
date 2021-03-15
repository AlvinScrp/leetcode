package leetcode_contest.weekly_200;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P1 {

    public static void main(String[] args) {

        System.out.println();
    }


    public int countGoodTriplets(int[] arr, int a, int b, int c) {

        int n = arr.length;
        if (n < 3) return 0;

        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a
                            && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }
        return count;

    }


}
