package lintcode;

import java.util.ArrayList;
import java.util.List;

public class Lint1145 {
    public List<List<String>> getList(List<List<String>> datalist1, List<List<String>> datalist2) {
        // write your code here
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < datalist1.size(); i++) {
            List<String> e = new ArrayList<>();
            e.add(datalist1.get(i).get(1));
            int sum=0;
            for (int j = 2; j <= 6; j+=2) {
                String m=datalist2.get(i).get(j);
                e.add(m);
                sum+=(Integer.parseInt(m));
            }
            e.add(String.valueOf(sum));
            ans.add(e);

        }
        return ans;
    }
}
