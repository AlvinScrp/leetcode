package leetcode_contest.biweekly_25;

import java.util.*;

public class P4_5387 {

    public static void main(String[] args) {
        List<List<Integer>> hats = new ArrayList<>();
        hats.add(Arrays.asList(3, 4));
        hats.add(Arrays.asList(4, 5));
        hats.add(Arrays.asList(5));
        System.out.println(numberWays(hats));

        long time=System.currentTimeMillis();
        hats = new ArrayList<>();
        hats.add(Arrays.asList(1, 2, 4, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 18, 19, 20, 23, 24, 25));
        hats.add(Arrays.asList(2, 5, 16));
        hats.add(Arrays.asList(1, 4, 5, 6, 7, 8, 9, 12, 15, 16, 17, 19, 21, 22, 24, 25));
        hats.add(Arrays.asList(1, 3, 6, 8, 11, 12, 13, 16, 17, 19, 20, 22, 24, 25));
        hats.add(Arrays.asList(11, 12, 14, 16, 18, 24));
        hats.add(Arrays.asList(2, 3, 4, 5, 7, 8, 13, 14, 15, 17, 18, 21, 24));
        hats.add(Arrays.asList(1, 2, 6, 7, 10, 11, 13, 14, 16, 18, 19, 21, 23));
        hats.add(Arrays.asList(1, 3, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 18, 20, 21, 22, 23, 24, 25));
        hats.add(Arrays.asList(2, 3, 4, 6, 7, 10, 12, 14, 15, 16, 17, 21, 22, 23, 24, 25));
        System.out.println(numberWays(hats));
        System.out.println("cost:"+(System.currentTimeMillis()-time));


    }

//    static int res = 0;
//        public static int numberWays(List<List<Integer>> hats) {
//        if (hats.size() > 40) {
//            return 0;
//        }
//        res = 0;
//        LinkedList<Integer> chooses = new LinkedList<>();
//        dfs(hats, 0, chooses);
//        return res;
//
//    }
////778256459
//    private static void dfs(List<List<Integer>> hats, int index, LinkedList<Integer> chooses) {
//        if (index == hats.size()) {
//            res = res + 1;
//            if (res == 1000000007) {
//                res = 0;
//            }
//            return;
//        }
//
//        List<Integer> hat = new ArrayList<>(hats.get(index));
//        hat.removeAll(chooses);
//        for (Integer h : hat) {
//            chooses.add(h);
//            dfs(hats, index + 1, chooses);
//            chooses.removeLast();
//        }
//
//    }


    static int res = 0;
    public static int numberWays(List<List<Integer>> hats) {
        if (hats.size() > 40) {
            return 0;
        }
        res = 0;
        int[] chooses = new int[40];
        dfs(hats, 0, chooses);
        return res;

    }

    //778256459
    private static void dfs(List<List<Integer>> hats, int index, int[] chooses) {
        if (index == hats.size()) {
            res = res + 1;
            if (res == 1000000007) {
                res = 0;
            }
            return;
        }

        List<Integer> hat =new ArrayList<>(hats.get(index)) ;
        for (Integer h : hat) {
            if (chooses[h] == 0) {
                chooses[h] = 1;
                dfs(hats, index + 1, chooses);
                chooses[h] = 0;
            }
        }

    }
}
