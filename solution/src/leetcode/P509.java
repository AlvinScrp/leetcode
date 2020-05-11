package leetcode;

public class P509 {


    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        int fa = 0, fb = 1, temp;
        for (int i = 2; i <= N; i++) {
            temp = fb;
            fb = fa + fb;
            fa = temp;
        }
        return fb;
    }
}
