package leetcode_contest.weekly_230;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P5689 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int index = "type".equals(ruleKey) ? 0 : ("color".equals(ruleKey) ? 1 : 2);
        int result = 0;
        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) result++;
        }
        return result;

    }
}
