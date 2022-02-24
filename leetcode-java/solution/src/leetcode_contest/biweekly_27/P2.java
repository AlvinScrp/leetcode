package leetcode_contest.biweekly_27;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class P2 {

    public static void main(String[] args) {
        System.out.println(new P2().hasAllCodes("00110110", 2));
        System.out.println(new P2().hasAllCodes("00110", 2));
        System.out.println(new P2().hasAllCodes("0110", 1));
        System.out.println(new P2().hasAllCodes("0110", 2));
        System.out.println(new P2().hasAllCodes("0000000001011100", 4));

    }

    public boolean hasAllCodes(String s, int k) {
        if (s == null || s.length() == 0) return false;
        if (k == 0) return false;

        Set<String> set = new HashSet<>();
        for (int i = 0; i + k - 1 < s.length(); i++) {
            set.add(s.substring(i, i + k));
        }
        return set.size() == (1 << k);

    }


}
