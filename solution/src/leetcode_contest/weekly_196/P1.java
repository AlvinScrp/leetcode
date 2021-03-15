package leetcode_contest.weekly_196;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P1 {

    public static void main(String[] args) {

        System.out.println(canMakeArithmeticProgression(new int[]{1,5,3}));
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 2) return true;
        Arrays.sort(arr);

        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) return false;
        }
        return true;
    }


}
