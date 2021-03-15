package leetcode_contest.weekly_196;

public class P2 {

    public static void main(String[] args) {

        System.out.println(getLastMoment(4,new int[]{4,3},new int[]{0,1}));
        System.out.println(getLastMoment(7,new int[]{},new int[]{0,1,2,3,4,5,6,7}));
        System.out.println(getLastMoment(7,new int[]{0,1,2,3,4,5,6,7},new int[]{}));
        System.out.println(getLastMoment(9,new int[]{5},new int[]{4}));
        System.out.println(getLastMoment(6,new int[]{6},new int[]{0}));

    }

    public static int getLastMoment(int n, int[] left, int[] right) {

        int ans = 0;

        for (int l : left) {
            ans = Math.max(ans, l-0);
        }
        for (int r : right) {
            ans = Math.max(ans, n-r);
        }
        return ans;
    }


}
