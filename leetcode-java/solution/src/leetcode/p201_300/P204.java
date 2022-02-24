package leetcode.p201_300;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class P204 {

    public static void main(String[] args) {
        System.out.println(new P204().countPrimes(499979));
    }

    public int countPrimes2(int n) {
        if (n <= 2) return 0;

//        int count = 1;
        Set<Integer> primes = new TreeSet<>();
        primes.add(2);
        for (int i = 3; i < n; i++) {
            boolean can = false;
            double sqrt = Math.sqrt(i);
            for (Integer prime : primes) {
                if (prime > sqrt) break;
                if (i % prime == 0) {
                    can = true;
                    break;
                }
            }
            if (!can) primes.add(i);
//            if (isPrime(i)) count++;

        }
        return primes.size();

    }

    public int countPrimes(int n) {
        if (n <= 2) return 0;

        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        nums[1]= nums[0] = 0;

        for (int i = 2; i < n; i++) {
            if (nums[i] == 1) {
                for (int j = i + i; j < n; j += i) {
                    nums[j] = 0;
                }
            }
        }

        int ans = 0;
        for (int num : nums) {
            ans += num;
        }
        return ans;

    }


}
