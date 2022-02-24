package leetcode_contest.weekly_194;

public class P1 {

    public static void main(String[] args) {
        System.out.println();
        System.out.println(new P1().xorOperation(5, 0));
        System.out.println(new P1().xorOperation(4, 3));
        System.out.println(new P1().xorOperation(1, 7));

    }

    public int xorOperation(int n, int start) {
        int ans = start;
        for (int i = 1; i < n; i++) ans ^= (start + (2* i));
        return ans;
    }


}
