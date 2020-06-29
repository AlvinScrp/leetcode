package leetcode.p1_100;

import java.util.ArrayList;
import java.util.List;

public class P89 {

    public static void main(String[] args) {
        System.out.println( new P89().grayCode(3));
    }




    public List<Integer> grayCode(int n) {

        List<Integer> res = new ArrayList<>();
        res.add(0);

        int mask = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) | mask);
            }
            mask = mask << 1;
        }
        return res;
    }
}
