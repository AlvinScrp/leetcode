public class P198_house_robber {


    public static void main(String[] args) {


        int[] coins1 = {1,2,3,1};
        int[] coins2 = {2,7,9,3,1};

        System.out.println(rob(coins1));
        System.out.println(rob(coins2));
    }


    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int max0 = nums[0];
        int max1 = Math.max(nums[0], nums[1]);
        int temp;
        for (int i = 2; i < n; i++) {
            temp = max0 + nums[i];
            max0 = max1;
            max1 = Math.max(max1, temp);
        }
        return max1;
    }

}
