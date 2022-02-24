package leetcode.p201_300;

public class P263 {

    public boolean isUgly(int num) {
        int[] primes = new int[]{2, 3, 5};
        for (int prime : primes) for (; num % prime == 0; num /= prime) ;
        return num == 1;

    }
}
