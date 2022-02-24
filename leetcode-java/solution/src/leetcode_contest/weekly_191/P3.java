package leetcode_contest.weekly_191;

import java.util.*;

public class P3 {

    public static void main(String[] args) {
        System.out.println(new P3().minReorder(6,new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}}));

    }

    int count;

    public int minReorder(int n, int[][] connections) {
        count = 0;
        Set<Integer> checkedNums = new HashSet<>(Arrays.asList(0));
        List<int[]> unCheckConnections = Arrays.asList(connections);
        checkConnections(checkedNums, unCheckConnections);
        return count;

    }

    private void checkConnections(Set<Integer> checkedNums, List<int[]> unCheckConnections) {
        if (unCheckConnections.isEmpty()) return;
        List<int[]> leaveConnections = new ArrayList<>();
        for (int[] connection : unCheckConnections) {
            int start = connection[0];
            int end = connection[1];
            if (checkedNums.contains(start)) {
                checkedNums.add(end);
                count++;
            } else if (checkedNums.contains(end)) {
                checkedNums.add(start);

            } else {
                leaveConnections.add(connection);
            }
        }
        checkConnections(checkedNums, leaveConnections);
    }


}
