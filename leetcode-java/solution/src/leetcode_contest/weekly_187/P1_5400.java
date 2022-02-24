package leetcode_contest.weekly_187;

import java.util.*;

public class P1_5400 {

    public static void main(String[] args) {


        List<List<String>> paths = new ArrayList<>();
        paths.add(Arrays.asList("pYyNGfBYbm", "wxAscRuzOl"));
        paths.add(Arrays.asList("kzwEQHfwce", "pYyNGfBYbm"));
        System.out.println(new P1_5400().destCity(paths));

    }

    public String destCity(List<List<String>> paths) {

        Set<String> starts = new HashSet<>();
        List<String> ends = new LinkedList<>();

        for (List<String> path : paths) {
            starts.add(path.get(0));
            ends.add(path.get(1));
        }
        for (String end : ends) {
            if (!starts.contains(end)) {
                return end;
            }
        }

        return "";


    }
}
