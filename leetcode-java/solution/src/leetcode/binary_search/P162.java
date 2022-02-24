package leetcode.binary_search;

public class P162 {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int[] a = nums;
        int index = find(a, 0, a.length - 1);
        if (index == -1) {
            index = a[0] > a[1] ? 0 : a.length - 1;
        }
        return index;
    }

    private int find(int[] a, int lo, int hi) {
        if (hi - lo <= 1) return -1;

        int mid = (hi - lo) / 2 + lo;
        if (a[mid - 1] < a[mid] && a[mid] > a[mid + 1]) {
            return mid;
        } else if (a[mid - 1] > a[mid] && a[mid] < a[mid + 1]) {
            return find(a, lo, mid);
        } else if (a[mid] > a[mid + 1]) {
            return find(a, lo, mid);
        } else {
            return find(a, mid, hi);
        }

    }
}
