package leetcode.p201_300;

import java.util.HashSet;
import java.util.Set;

public class P217 {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> sets=new HashSet<>();
        for (int num : nums) {
            if(sets.contains(num))return false;
            sets.add(num);
        }
        return true;
    }
}
