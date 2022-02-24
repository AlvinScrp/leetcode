package leetcode.p301_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class P380 {

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(2);
        boolean param_2 = obj.remove(1);
        int param_3 = obj.getRandom();
    }

    static class RandomizedSet {

        private ArrayList<Integer> list = new ArrayList<>();

        /**
         * key --> val
         * value -> val index
         */
        private HashMap<Integer, Integer> map = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {

        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                map.put(val, list.size());
                list.add(val);
                return true;
            }
            return false;

        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int index = map.get(val);
                int tempVal = list.get(list.size() - 1);
                list.set(index, tempVal);
                map.put(tempVal, index);
                map.remove(val);
                list.remove(list.size() - 1);
                return true;
            }
            return false;

        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return  list.get(new Random().nextInt(list.size()));
        }
    }

}
