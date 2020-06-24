package leetcode.bit_manipulation;

import java.util.HashSet;
import java.util.Set;

public class P898 {

    public static void main(String[] args) {
        System.out.println(new P898().subarrayBitwiseORs(new int[]{0}));
        System.out.println(new P898().subarrayBitwiseORs(new int[]{1, 1, 2}));
        System.out.println(new P898().subarrayBitwiseORs(new int[]{1, 2, 4}));
    }

    public int subarrayBitwiseORs(int[] A) {

        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            res.add(A[i]);
            for (int j = i - 1; j > 0; j--) {
                if ((A[j] | A[i]) == A[j]) break;
                A[j] |= A[i];
                res.add(A[j]);
            }
        }
        return res.size();

    }
}
