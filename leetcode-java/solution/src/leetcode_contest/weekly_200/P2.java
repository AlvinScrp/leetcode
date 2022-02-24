package leetcode_contest.weekly_200;

import java.util.Arrays;

public class P2 {

    public static void main(String[] args) {

        System.out.println();
    }

    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        if (k >= n - 1) {
            Arrays.sort(arr);
            return arr[n - 1];
        }

        return calculate(arr, k, k);

    }

    private int calculate(int[] arr, int thisK, int k) {


        int num = arr[0];
        int n = arr.length;
        int index = -1;
        for (int i = 1; i < n; i++) {
            if (num < arr[i]) {
                index = i;
                break;
            }
        }
        if (index == -1 || index > thisK) return arr[0];

        int[] newArr = new int[n];

        int j = 0;
        for (int i = index; i < n; ) {
            newArr[j++] = arr[i++];
        }
        for (int i = 1; i < index; ) {
            newArr[j++] = arr[i++];
        }
        newArr[j] = arr[0];

        return calculate(newArr, k - 1, k);


    }


}
