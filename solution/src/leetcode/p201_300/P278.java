package leetcode.p201_300;

public class P278 {

    public int firstBadVersion(int n) {
        return binary(0, n);
    }

    private int binary(int lo, int hi) {

        if (lo >= hi) return lo;

        int mid = (hi - lo) / 2 + lo;
        return isBadVersion(mid) ? binary(lo, mid) : binary(mid + 1, hi);

    }


    boolean isBadVersion(int version) {
        return version >= 5;
    }
}
