package leetcode_jianzhioffer;

public class J10_1 {


    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        int fa = 0, fb = 1, temp;
        for (int i = 2; i <= N; i++) {
            temp = fb;
            fb = (fa + fb)%1000000007;
            fa = temp;
        }
        return fb;
    }
}
