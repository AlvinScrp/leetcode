package leetcode.dp;

public class P526 {


    public static void main(String[] args) {

        System.out.println(new P526().countArrangement(2));
        System.out.println(new P526().countArrangement(0));
        System.out.println(new P526().countArrangement(1));
        System.out.println(new P526().countArrangement(5));

    }

    //N<=15
    public int countArrangement(int N) {
//        if (N <= 2) return N;
        Integer[] dp = new Integer[1 << N];//i包含的元素放入排列最前端产生的优美排列数
        int chosen = (1 << N) - 1;
        int count = count(N, chosen, N, dp);

        for (int i = 0; i < dp.length; i++) {
            System.out.println(Integer.toBinaryString(i) + ":" + dp[i]);
        }
        return count;
    }


    private int count(int max, int chosen, int chosenCount, Integer[] dp) {

//        System.out.println(Integer.toBinaryString(chosen));

        if (dp[chosen] != null) return dp[chosen];

        if (chosen == 0 || (chosen & (chosen - 1)) == 0) {
            dp[chosen] = 1;
        } else {

            int count = 0;
            for (int i = 1; i <= max; i++) {
                int choosing = 1 << (i - 1);
                if ((chosen & choosing)  >0) {
                    int index = chosenCount;
                    if (i % index == 0 || index % i == 0) {
                        count += count(max, chosen - choosing, chosenCount - 1, dp);
                    }
                }

            }
            dp[chosen] = count;
        }
        return dp[chosen];

    }
}
