package leetcode_contest.weekly_186;

public class P2_5393 {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println(maxScore(new int[]{2, 2, 2}, 2));
        System.out.println(maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
        System.out.println(maxScore(new int[]{53, 14, 91, 35, 51, 9, 80, 27, 6, 15, 77, 86, 34, 62, 55, 45, 91, 45, 23, 75, 66, 42, 62, 13, 34, 18, 89, 67, 93, 83, 100, 14, 92, 73, 48, 2, 47, 93, 99, 100, 88, 84, 48}
                , 43));


    }

    public static int maxScore(int[] cardPoints, int k) {
        int length = cardPoints.length;
        k = length - k;
        int sum = 0;
        int minSum = 0;
        int currentSum = 0;
        for (int i = 0; i < length; i++) {
            sum += cardPoints[i];
            if (i < k) {
                currentSum += cardPoints[i];
                minSum += cardPoints[i];
            } else {
                currentSum = currentSum - cardPoints[i - k] + cardPoints[i];
                minSum = Math.min(minSum, currentSum);
            }

        }
        return sum - minSum;

    }

    private static int dfs(int[] cardPoints, int left, int right, int currentSum, int step) {
        if (step == 0) {
            return currentSum;
        }
        int sum1 = dfs(cardPoints, left + 1, right, currentSum + cardPoints[left], step - 1);
        int sum2 = dfs(cardPoints, left, right - 1, currentSum + cardPoints[right], step - 1);
        return Math.max(sum1, sum2);
    }

//    public static int maxScore(int[] cardPoints, int k) {
//        k=Math.min(k,cardPoints.length);
//        int maxSum = dfs(cardPoints, 0, cardPoints.length - 1, 0, k);
//        return maxSum;
//    }
//
//    private static int dfs(int[] cardPoints, int left, int right, int currentSum, int step) {
//        if (step == 0) {
//            return currentSum;
//        }
//        int sum1 = dfs(cardPoints, left + 1, right, currentSum + cardPoints[left], step - 1);
//        int sum2 = dfs(cardPoints, left, right - 1, currentSum + cardPoints[right], step - 1);
//        return Math.max(sum1, sum2);
//    }
}
