import java.util.Random;

class A470 {

    public static void main(String[] args) {
        // System.out.println(new A470().new Solution());
        int[] values = new int[7];
        Random random = new Random();
        for (int i = 0; i < 1400; i++) {
            values[random.nextInt(7)]++;
        }
        for (int i = 0; i < values.length; i++) {
            System.out.println(i + ":" + values[i]);
        }


    }

    class SolBase {
        Random random = new Random();

        public int rand7() {
            return random.nextInt(7) + 1;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     *
     * @return a random integer in the range 1 to 7
     */
    class Solution extends SolBase {
        public int rand10() {
            int a, b;
            while ((a = rand7()) > 6) ;//a:1-6
            while ((b = rand7()) > 5) ;//b:1-5

            return a % 2 == 0 ? b : b + 5;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







