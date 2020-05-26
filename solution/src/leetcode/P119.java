package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P119 {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            list.add(1);
            for (int j = list.size() - 2; j > 0; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        return list;
    }
}
