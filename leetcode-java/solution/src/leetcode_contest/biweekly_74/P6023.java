package leetcode_contest.biweekly_74;

public class P6023 {

    public static void main(String[] args) {
        System.out.println(minimumWhiteTiles("10110101", 2, 2));
    }

    public static int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int[][] f = new int[floor.length() + 1][numCarpets + 1];

        for (int i = 1; i <= floor.length(); i++) {
            for (int j = 0; j <= numCarpets; j++) {
                f[i][j] = f[i - 1][j] + (floor.charAt(i - 1) - '0');
                if (j == 0) continue;
                if (i - carpetLen >= 0) {
                    f[i][j] = Math.min(f[i][j], f[i - carpetLen][j - 1]);
                } else if (i - carpetLen < 0) {
                    f[i][j] = 0;
                }
            }
        }
        return f[floor.length()][numCarpets];
    }


}
