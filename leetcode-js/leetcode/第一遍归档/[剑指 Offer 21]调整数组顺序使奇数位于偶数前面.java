import java.util.concurrent.locks.LockSupport;

class A_Offer_21 {

    public static void main(String[] args) {
//        int[] ans = new A_Offer_21().new Solution().exchange(new int[]{1, 2, 3, 4, 5});
//        for (int an : ans) {
//            System.out.print(an + ",");
//        }
//        System.out.println();

        new A_Offer_21().print();

    }

    Thread t2 = null;
    Thread t1 = null;

    private void print() {
        t1 = new Thread() {
            @Override
            public void run() {
                super.run();
                LockSupport.park();
                for (int i = 1; i < 100; i += 2) {
                    System.out.print(i + ",");
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        };
        t2 = new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i <= 100; i += 2) {
                    System.out.print(i + ",");
                    LockSupport.unpark(t1);
                    LockSupport.park();
                }
            }
        };
        t2.start();
        t1.start();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] exchange(int[] nums) {
            int i = 0;
            int j = nums.length - 1;
            while (i < j) {
                if (nums[i] % 2 == 1) i++;
                else if (nums[j] % 2 == 0) j--;
                else {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j--;
                }

            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







