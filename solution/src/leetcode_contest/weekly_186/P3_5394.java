package leetcode_contest.weekly_186;

import java.util.*;

public class P3_5394 {

    public static void main(String[] args) {

        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(1, 2, 3, 4, 5));
        nums.add(Arrays.asList(6, 7));
        nums.add(Arrays.asList(8));
        nums.add(Arrays.asList(9, 10, 11));
        nums.add(Arrays.asList(12, 13, 14, 15, 16));

        int[] res = findDiagonalOrder(nums);
        for (int re : res) {
            System.out.print("," + re);
        }

    }

//    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
//
//        int maxRow = nums.size(), maxColumn = 0, maxSize = 0;
//        for (List<Integer> num : nums) {
//            maxSize += num.size();
//            maxColumn = Math.max(maxColumn, num.size());
//        }
//        int[] res = new int[maxSize];
//        int rowSize = nums.size();
//        for (int i = 0; i < rowSize; i++) {
//            List<Integer> num = nums.get(i);
//            int columnSize = num.size();
//            for (int j = 0; j < columnSize; j++) {
//                int d = i + j;
//                if (i == 0 && j == 0) {
//                    res[0] = num.get(0);
//                } else {
//                    res[d * (d + 1) / 2 + j] = num.get(j);
//                }
//            }
//        }
//        return res;
//
//    }

    public static int[] findDiagonalOrder(List<List<Integer>> nums) {


        int maxSize = 0;

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int maxD = 0;

        int rowSize = nums.size();
        for (int i = rowSize - 1; i >= 0; i--) {
            List<Integer> num = nums.get(i);
            maxSize += num.size();
            for (int j = 0; j < num.size(); j++) {
                maxD = Math.max(maxD, i + j);
                if (!map.containsKey(i + j)) {
                    map.put(i + j, new ArrayList());
                }
                map.get(i + j).add(nums.get(i).get(j));
            }
        }

        int[] res = new int[maxSize];
        int index = 0;

        for (int i = 0; i <= maxD; i++) {
            for (Integer o : map.get(i)) {
                res[index++] = o;
            }
        }
        return res;

    }

}
