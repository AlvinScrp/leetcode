package leetcode_contest.biweekly_74;

import java.util.HashMap;
import java.util.Map;

public class P6020 {

    public static void main(String[] args) {
        
    }

    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) return false;
        }
        return true;
    }


}
