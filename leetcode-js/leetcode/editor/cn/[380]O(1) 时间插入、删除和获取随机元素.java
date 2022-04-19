import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class A380 {

    public static void main(String[] args) {
        // System.out.println(new A380().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet {

        private int[] nums = new int[200001];
        int count = 0;
        private Map<Integer, Integer> map = new HashMap<>();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            nums[count] = val;
            count++;
            map.put(val, count - 1);
            return true;

        }

        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int index = map.get(val);
                int lastValue = nums[count-1];
                nums[index] =lastValue;
                map.put(lastValue, index);
                map.remove(val);
                count--;
                return true;
            }
            return false;
        }

        public int getRandom() {
            return nums[new Random().nextInt(count)];

        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}







