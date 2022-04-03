package leetcode_contest.weekly_287;

public class P5219 {

    public static void main(String[] args) {

//        System.out.println(new P5219().maximumCandies(new int[]{5, 8, 6}, 3));
//        System.out.println(new P5219().maximumCandies(new int[]{2, 5}, 11));
        System.out.println(new P5219().maximumCandies(new int[]{3, 5, 9}, 1));

    }

    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        if (k >= sum) return k == sum ? 1 : 0;
        long l = 1L, r = sum / k;
        while (l < r) {
            long mid = l + (r - l + 1) / 2;
            if (isValueOk(mid, candies, k)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return (int) l;
    }

    private boolean isValueOk(long val, int[] candies, long k) {
        long count = 0;
        for (int candy : candies) {
            count += candy / val;
        }
        return count >= k;
    }


}
