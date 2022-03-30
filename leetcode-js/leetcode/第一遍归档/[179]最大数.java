import java.util.Arrays;

class A179 {

    public static void main(String[] args) {
        // System.out.println(new A179().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            String[] array = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                array[i] = "" + nums[i];
            }
            Arrays.sort(array, (x, y) -> ("" + y + x).compareTo("" + x + y));

            if (array[0].equals("0")) return "0";
            StringBuilder sb = new StringBuilder();
            for (String s : array) sb.append(s);
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







