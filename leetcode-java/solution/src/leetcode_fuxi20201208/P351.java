package leetcode_fuxi20201208;

public class P351 {

    public static void main(String[] args) {
        System.out.println(new P351().numberOfPatterns(1,1));
        System.out.println(new P351().numberOfPatterns(1,9));
        System.out.println(new P351().numberOfPatterns(5,9));
    }


    public int numberOfPatterns(int m, int n) {
        int sum = 0;
        boolean[] visited = new boolean[10];
        int[][] mid = new int[10][10];
        mid[1][3] = mid[3][1] = 2;
        mid[7][9] = mid[9][7] = 8;
        mid[1][7] = mid[7][1] = 4;
        mid[3][9] = mid[9][3] = 6;
        mid[3][7] = mid[7][3] = mid[1][9] = mid[9][1] = 5;
        mid[4][6] = mid[6][4] = mid[2][8] = mid[8][2] = 5;


        for (int i = m; i <= n; i++) {
            sum += dfs(1, i - 1, visited, mid) * 4;
            sum += dfs(2, i - 1, visited, mid) * 4;
            sum += dfs(5, i - 1, visited, mid);
        }
        return sum;
    }

    public int dfs(int num, int count, boolean[] visited, int[][] mid) {
        if (count == 0) return 1;

        int result = 0;
        visited[num] = true;
        for (int i = 1; i <= 9; i++) {
            if (!visited[i] && (mid[num][i] == 0 || visited[mid[num][i]])) {
                result += dfs(i, count - 1, visited, mid);
            }
        }
        visited[num] = false;
        return result;

    }
}
