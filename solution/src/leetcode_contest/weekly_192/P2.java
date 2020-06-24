package leetcode_contest.weekly_192;

import java.util.Arrays;

public class P2 {

    public static void main(String[] args) {
        System.out.println(new P2());
    }

    public int[] getStrongest(int[] arr, int k) {

        Arrays.sort(arr);
        int mid = (arr.length - 1) / 2;
        int[] ans = new int[k];

        for (int i = 0, j = arr.length - 1, l = 0; l < k; ) {
            if (i == mid) {
                ans[l++] = arr[j--];
            } else if (j == mid) {
                ans[l++] = arr[i++];
            } else {
                if (Math.abs(arr[i] - arr[mid]) > Math.abs(arr[j] - arr[mid])) {
                    ans[l++] = arr[i++];
                } else {
                    ans[l++] = arr[j--];
                }
            }
        }
        return ans;

    }
}
