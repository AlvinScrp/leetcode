import java.util.ArrayList;
import java.util.List;

class A229 {

    public static void main(String[] args) {
        List<Integer> ans = new A229().new Solution().majorityElement(new int[]{2, 1, 1, 3, 1, 4, 5, 6});
        for (Integer an : ans) {
            System.out.print(an + ",");
        }
        System.out.println("---");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int value1 = 0, value2 = 0, count1 = 0, count2 = 0;
            for (int num : nums) {
                if (count1 > 0 && num == value1) {
                    count1++;
                } else if (count2 > 0 && num == value2) {
                    count2++;
                } else if (count1 == 0) {
                    value1 = num;
                    count1++;
                } else if (count2 == 0) {
                    value2 = num;
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }

            List<Integer> ans = new ArrayList<>();
            int c1 = 0, c2 = 0;
            for (int num : nums) {
                if (num == value1 && count1 > 0) c1++;
                if (num == value2 && count2 > 0) c2++;
            }
            if (count1 > 0 && c1 * 3 > nums.length) ans.add(value1);
            if (count2 > 0 && c2 * 3 > nums.length) ans.add(value2);
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







