package leetcode_contest.weekly_188;

public class P3_ {

    public static void main(String[] args) {
        System.out.println(0 ^ 2);
        System.out.println(2 ^ 2);
        new P3_().countTriplets(new int[]{2, 3, 1, 6, 7});

    }

    public int countTriplets(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) return 0;
        int n = arr.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j == i) {
                    f[i][j] = arr[j];
                } else {
                    f[i][j] = f[i][j - 1] ^ arr[j];
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j; k < n; k++) {
                    if (f[i][j - 1] == f[j][k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
