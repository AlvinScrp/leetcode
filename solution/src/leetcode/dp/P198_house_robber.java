package leetcode.dp;

public class P198_house_robber {


    public static void main(String[] args) {


        int[] coins1 = {1, 2, 3, 1};
        int[] coins2 = {2, 7, 9, 3, 1};

        System.out.println(rob(coins1));
        System.out.println(rob(coins2));
    }


    public static int rob(int[] nums) {
        int max0 = 0, max1 = 0, temp;
        for (int i = 0; i < nums.length; i++) {
            temp = max0 + nums[i];
            max0 = max1;
            max1 = Math.max(max1, temp);
        }
        return max1;
    }

//    public static int rob(int[] nums) {
//        int n = nums.length;
//        int[] res = new int[2];
//        int doit,nodo;
//        for (int i = 0; i < n; i++) {
//            nodo=Math.max(res[1],res[0]);
//            doit=nums[i]+res[0];
//            res[0]=nodo;
//            res[1]=doit;
//        }
//        return Math.max(res[0], res[1]);
//    }

}
