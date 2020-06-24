package leetcode_contest.weekly_191;

public class P4 {

    public static void main(String[] args) {
        System.out.println();

    }
    private long[] factorial = new long[9];

    public double getProbability(int[] balls) {
        factorial[0] = 1;
        for (int i = 1; i < 9; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        int sum = 0;
        for (int ball : balls) {
            sum += ball;
        }
        long[] count = new long[2];
        getProbability(0, new int[balls.length], sum / 2, balls, count);
        return (double) count[0] / count[1];
    }

    private void getProbability(int index, int[] curr, int sum, int[] balls, long[] count) {
        if (index == curr.length) {
            if (sum == 0) {
                int count1 = 0, count2 = 0;
                long s = 1;
                for (int i = 0; i < curr.length; i++) {
                    if (curr[i] == balls[i]) {
                        count1++;
                    } else if (curr[i] == 0) {
                        count2++;
                    } else {
                        s *= factorial[balls[i]] / factorial[curr[i]] / factorial[balls[i] - curr[i]];
                        count1++;
                        count2++;
                    }
                }
                if (count1 == count2) {
                    count[0] += s;
                }
                count[1] += s;
            }
        } else {
            for (int i = 0; i <= Math.min(sum, balls[index]); i++) {
                curr[index] = i;
                getProbability(index + 1, curr, sum - i, balls, count);
                curr[index] = 0;
            }
        }
    }


}
