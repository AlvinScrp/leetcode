package leetcode_contest.weekly_286;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P5268 {

    public static void main(String[] args) {
        System.out.println();

    }


    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set11 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
            set11.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        set1.removeAll(set2);
        set2.removeAll(set11);
        ans.add(new ArrayList<>(set1));
        ans.add(new ArrayList<>(set2));
        return ans;
    }

}
