package leetcode_contest.biweekly_26;

import java.util.ArrayList;
import java.util.List;

public class P2_5397 {

    public static void main(String[] args) {
//        List<String> res = simplifiedFractions(4);
//        List<String> res = simplifiedFractions(4);
        List<String> res = simplifiedFractions(6);
        System.out.println(res);
//        check(2,4);
//        check(1,18);
    }

    public static List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0 || n == 1) return res;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (check(i, j)) res.add(j + "/" + i);
            }
        }

        return res;

    }

    public static boolean check(int p, int q) {

        int temp;
        if (p < q) {
            temp = p;
            p = q;
            q = temp;
        }
        int temp1, temp2;
        while (p % q != 0) {
            temp1 = q;
            temp2 = p - q;
            p = Math.max(temp1, temp2);
            q = Math.min(temp1, temp2);
        }
        return q == 1;

    }


}
