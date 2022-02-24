package leetcode_contest.biweekly_27;

import java.util.Arrays;

public class P1 {

    public static void main(String[] args) {
        System.out.println();

    }

    public boolean canBeEqual(int[] target, int[] arr) {
        if (target == null || arr == null) return false;

        Arrays.sort(arr);
        Arrays.sort(target);

        boolean can = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target[i]) {
                can = false;
                break;
            }
        }
        return can;

    }


}
