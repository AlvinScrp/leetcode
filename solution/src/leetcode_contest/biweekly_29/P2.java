package leetcode_contest.biweekly_29;

public class P2 {

    public static void main(String[] args) {
        System.out.println(kthFactor(12,3));
        System.out.println(kthFactor(7,2));
        System.out.println(kthFactor(4,4));
        System.out.println(kthFactor(1,1));
        System.out.println(kthFactor(1000,3));

    }

    public static int kthFactor(int n, int k) {

        for (int i = 1; i <= n && k > 0; i++) {
            if (n %i==0){
                k--;
                if(k==0) return i;
            }
        }
        return -1;

    }


}
