package leetcode_contest.weekly_193;

import java.util.*;

public class P2 {

    public static void main(String[] args) {
        System.out.println();
//        new P2().findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3);
        new P2().findLeastNumOfUniqueInts(new int[]{2, 4, 1, 8, 3, 5, 1, 3}, 3);

    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        if (k >= arr.length) return 0;

        List<Integer> nums = new ArrayList<>();
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i : arr) {
            if (counts.containsKey(i)) {
                counts.put(i, counts.get(i) + 1);
            } else {
                counts.put(i, 1);
                nums.add(i);
            }
        }
        Collections.sort(nums, Comparator.comparingInt(counts::get));

        System.out.println(counts.entrySet());
        System.out.println(nums);
        for (Integer num : nums) {
            if (!counts.containsKey(num)) break;
            int count = counts.get(num);
            if (k < count) {
                counts.put(num, count - k);
                break;
            } else if (k == count) {
                counts.remove(num);
                break;
            } else if (k > count) {
                counts.remove(num);
                k -= count;
            }
        }
        System.out.println(counts.entrySet());

        return counts.size();

    }


}
