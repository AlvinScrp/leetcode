package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                res.add(Arrays.asList(1));
                continue;
            }
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> pres = res.get(i - 1);
            for (int j = 0; j < pres.size() - 1; j++) {
                list.add(pres.get(j) + pres.get(j + 1));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}
