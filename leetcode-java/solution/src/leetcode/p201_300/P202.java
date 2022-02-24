package leetcode.p201_300;

import java.util.HashSet;
import java.util.Set;

public class P202 {

    Set<Integer> nums = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(new P202().isHappy(19));
    }

    public boolean isHappy(int n) {
//        System.out.println(n);
        if (n == 1) return true;
        nums.add(n);

        int ans = 0;
        while (n > 0) {
            ans += (n % 10) * (n % 10);
            n /= 10;
        }
        if (nums.contains(ans)) return false;
        return ans == 1 ? true : isHappy(ans);

    }
}
