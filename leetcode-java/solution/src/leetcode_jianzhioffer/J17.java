package leetcode_jianzhioffer;

import java.util.ArrayList;
import java.util.List;

public class J17 {

    public static void main(String[] args) {
        System.out.println(new J17().printNumbers(2));
    }

    public int[] printNumbers(int n) {
        int max = findMax(n);
        int[] res = new int[max];

        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }
        return res;

    }

    public static int findMax(int n) {
        int max = 0;
        while (n != 0) {
            max = max * 10 + 9;
            n--;
        }
        return max;
    }

//    public int[] printNumbers(int n) {
//        List<Integer> list = new ArrayList<>();
//
//        genNumbers(n, new ArrayList<>(), list);
//        int[] res = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            res[i] = list.get(i);
//        }
//        return res;
//
//    }
//    public List<Integer> printNumbers2(int n) {
//        List<Integer> list = new ArrayList<>();
//        genNumbers(n, new ArrayList<>(), list);
//        return list;
//
//    }

//    private void genNumbers(int n, List<Integer> current, List<Integer> list) {
//        if (n == 0) return;
//        List<Integer> res = new ArrayList<>();
//
//        if (current != null && !current.isEmpty()) {
//            for (Integer cc : current) {
//                for (int i = 0; i <= 3; i++) {
//                    res.add(cc * 10 + i);
//                }
//            }
//        } else {
//            for (int i = 1; i <= 3; i++) {
//                res.add(i);
//            }
//
//        }
//        list.addAll(res);
//        genNumbers(n - 1, res, list);
//    }
}
