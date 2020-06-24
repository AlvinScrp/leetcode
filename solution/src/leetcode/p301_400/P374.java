package leetcode.p301_400;

public class P374 {
    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }

    public static int guessNumber(int n) {

        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            int guess = guess(mid);
            if (guess == 0) lo = hi = mid;
            else if (guess > 0) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;

    }

    public static int guess(int num) {
        return num == 6 ? 0 : (num < 6 ? 1 : -1);
    }
}

