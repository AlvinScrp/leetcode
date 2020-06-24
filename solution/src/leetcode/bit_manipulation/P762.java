package leetcode.bit_manipulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P762 {

    public int countPrimeSetBits(int L, int R) {

        Set<Integer> z = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
        int ans=0;
        for (int i = L; i <= R; i++) {
            int count1 = 0;
            int n = i;
            for (; n > 0; count1++) n = n & (n - 1);
            if(z.contains(count1)) ans++;

        }
        return ans;

    }
}
