package leetcode_contest.biweekly_24;

import java.util.ArrayList;
import java.util.List;

public class P2 {

    public static void main(String[] args) {
//        findMinFibonacciNumbers(19);
        int i=1000000000;
//        Integer.MAX_VALUE
        System.out.println( Integer.MAX_VALUE>i);
    }

    public static int findMinFibonacciNumbers(int k) {

        List<Integer> fbncs = getFbncList();
        List<Integer> res = new ArrayList<>();
        int size = fbncs.size();
        for (int i = size - 1; i >= 0; ) {
            int fbncI = fbncs.get(i);
            if (k == 0) {
                break;
            }
            if (k >= fbncI) {
                k = k - fbncI;
                res.add(fbncI);
            } else if (k < fbncI) {
                i--;
            }
        }
//        System.out.println(res);


        return res.size();
    }


    public static List<Integer> getFbncList() {
        int f1 = 1, f2 = 1;

        List<Integer> aList = new ArrayList<>();
        aList.add(1);
        do {
            int temp = f2;
            f2 = f1 + f2;
            f1 = temp;
            aList.add(f1);
//          System.out.println(f2);

        } while (f2 < 1000000000);
        return aList;
    }
}
