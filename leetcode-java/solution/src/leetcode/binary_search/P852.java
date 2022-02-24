package leetcode.binary_search;

public class P852 {

    public int peakIndexInMountainArray(int[] A) {
        return find(A, 0, A.length - 1);
    }

    private int find(int[] a, int lo, int hi) {
        if (hi - lo <= 1) return -1;

        int mid = (hi - lo) / 2 + lo;
        if (a[mid - 1] < a[mid] && a[mid] > a[mid + 1]) {
            return mid;
        } else if (a[mid] > a[mid + 1]) {
            return find(a, lo, mid);
        } else {
            return find(a, mid, hi);
        }

    }
}
