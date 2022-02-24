package leetcode.p301_400;

import java.util.*;

public class P349 {
    public int[] intersection(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map1 = toMap(nums1);
        Map<Integer, Integer> map2 = toMap(nums2);

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            count=Math.min(count, map2.getOrDefault(num, 0));
            for (int i = 0; i < count; i++) list.add(num);

        }

        int[] ans = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            ans[i++] = integer;
        }
        return ans;

    }

    public Map<Integer, Integer> toMap(int[] nums1) {
        Map<Integer, Integer> map1 = new HashMap();
        for (int num1 : nums1) map1.put(num1, map1.getOrDefault(num1, 0) + 1);
        return map1;
    }
}
