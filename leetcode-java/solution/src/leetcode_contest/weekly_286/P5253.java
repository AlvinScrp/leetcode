package leetcode_contest.weekly_286;

public class P5253 {

    public static void main(String[] args) {
        System.out.println();
        long[] ans = new P5253().kthPalindrome(new int[]{1, 2, 3, 4, 5, 90}, 3);
        for (long an : ans) {
            System.out.print(an + ",");
        }
        System.out.println("]");
        ans = new P5253().kthPalindrome(
                new int[]{2, 201429812, 8, 520498110, 492711727, 339882032, 462074369, 9, 7, 6},
                1);
        for (long an : ans) {
            System.out.print(an + ",");
        }
        System.out.println("]");


    }

    public long[] kthPalindrome(int[] queries, int intLength) {
        int start = 1;
        for (int k = (intLength + 1) / 2; k > 1; k--) {
            start *= 10;
        }
        int end = start * 10 - 1;
        long[] ans = new long[queries.length];
        int count = 0;
        boolean odd = intLength % 2 == 0;
        for (int query : queries) {
            int num = intLength == 1 ? query : (start + query - 1);
            if (num < start || num > end) {
                ans[count++] = -1;
            } else {
                ans[count++] = intLength == 1 ? num : convert(num, odd);
            }
        }
        return ans;
    }

    private long convert(int num, boolean odd) {
        StringBuilder sb = new StringBuilder();
        sb.append(odd ? num : (num / 10));
        sb.reverse();
        sb.insert(0, num);
        return Long.parseLong(sb.toString());
    }


}
