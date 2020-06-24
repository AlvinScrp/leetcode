package leetcode.p1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P57 {

    public static void main(String[] args) {
        printInsert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        printInsert(new int[][]{{1, 5}}, new int[]{2, 3});
        printInsert(new int[][]{{1, 5}}, new int[]{6, 8});
        printInsert(new int[][]{{1, 5}}, new int[]{0, 0});
        printInsert(new int[][]{{0, 2}, {3, 3}, {6, 11}}, new int[]{9, 15});
        printInsert(new int[][]{{1, 5}, {6, 8}}, new int[]{0, 9});
        printInsert(new int[][]{{3, 5}, {12, 15}}, new int[]{6, 6});//[[3,5],[6,6],[12,15]]
        printInsert(new int[][]{{1, 4}, {9, 12}, {19, 22}}, new int[]{7, 13});//[[3,5],[6,6],[12,15]]


    }

    public static void printInsert(int[][] intervals, int[] newInterval) {
        print(insert(intervals, newInterval));
        print(insert2(intervals, newInterval));

    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();
        int i = 0;
        for (; i < intervals.length && newInterval[0] > intervals[i][1]; i++) {
            ans.add(intervals[i]);
        }
        List<int[]> temp = new ArrayList<>();
        for (; i < intervals.length && newInterval[1] >= intervals[i][0]; i++) {
            temp.add(intervals[i]);
        }
        if (temp.isEmpty()) {
            ans.add(new int[]{newInterval[0], newInterval[1]});
        } else {
            int min = Math.min(temp.get(0)[0], newInterval[0]);
            int max = Math.max(temp.get(temp.size() - 1)[1], newInterval[1]);
            ans.add(new int[]{min, max});
        }
        for (; i < intervals.length; i++) {
            ans.add(intervals[i]);
        }
        int[][] res = new int[ans.size()][2];
        for (int j = 0; j < ans.size(); j++) {
            res[j] = ans.get(j);
        }
        return res;
    }


    public static void print(int[][] ans) {
        for (int[] an : ans) {
            System.out.print("," + Arrays.toString(an));
        }
        System.out.println();
    }


//1, 4}, {9, 12}, {19, 22},
//        7, 13

    public static int[][] insert2(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) return new int[][]{newInterval};

        int start = -1, end = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] >= intervals[i][0]) {
                start = i;
            }
        }
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] <= intervals[i][1]) {
                end = i;
                break;
            }
        }

        //最左
        if (newInterval[1] < intervals[0][0]) {
            int[][] ans = new int[intervals.length + 1][2];
            int i = 0;
            ans[i++] = newInterval;
            for (int[] interval : intervals) {
                ans[i++] = interval;
            }
            return ans;
        }
        //最右
        if (newInterval[0] > intervals[intervals.length - 1][1]) {
            int[][] ans = new int[intervals.length + 1][2];
            int i = 0;
            for (int[] interval : intervals) {
                ans[i++] = interval;
            }
            ans[i++] = newInterval;
            return ans;
        }
        if (start == -1 || end == -1) {
            if (start == -1 && end == -1) {
                return new int[][]{newInterval};
            } else if (start == -1) {
                if (newInterval[1] < intervals[end][0]) {
                    int[][] ans = new int[intervals.length - end + 1][2];
                    ans[0] = newInterval;
                    for (int i = 1, j = end; j < intervals.length; j++) {
                        ans[i++] = intervals[j];
                    }
                    return ans;

                } else {
                    intervals[end][0] = newInterval[0];
                    int[][] ans = new int[intervals.length - end][2];
                    for (int i = 0, j = end; j < intervals.length; j++) {
                        ans[i++] = intervals[j];
                    }
                    return ans;

                }

            } else if (end == -1) {
                if (newInterval[0] > intervals[start][1]) {
                    int[][] ans = new int[start + 2][2];
                    int i = 0;
                    for (; i <= start; i++) {
                        ans[i] = intervals[i];
                    }
                    ans[i] = newInterval;
                    return ans;
                } else {
                    intervals[start][1] = newInterval[1];
                    int[][] ans = new int[start + 1][2];
                    int i = 0;
                    for (; i <= start; i++) {
                        ans[i] = intervals[i];
                    }
                    return ans;
                }

            }
        }


//1, 4}, {9, 12}, {19, 22},
//        7, 13

        //新节点的左右，均不在某个区间内
        if (newInterval[0] > intervals[start][1]
                && newInterval[1] < intervals[end][0]) {
            int[][] ans = new int[intervals.length - (end - start - 1) + 1][2];
            int i = 0;
            for (; i <= start; i++) {
                ans[i] = intervals[i];
            }
            ans[i++] = newInterval;
            for (int j = end; j < intervals.length; j++) {
                ans[i++] = intervals[j];
            }
            return ans;

        } else if (newInterval[0] <= intervals[start][1] && newInterval[1] >= intervals[end][0]) {
            intervals[start][1] = intervals[end][1];
            int[][] ans = new int[intervals.length - (end - start)][2];
            int i = 0;
            for (; i <= start; i++) {
                ans[i] = intervals[i];
            }
            for (int j = end + 1; j < intervals.length; j++) {
                ans[i++] = intervals[j];
            }
            return ans;
        } else if (newInterval[0] <= intervals[start][1] && newInterval[1] < intervals[end][0]) {
            intervals[start][1] = newInterval[1];
            int i = 0;
            int[][] ans = new int[intervals.length - (end - start - 1)][2];
            for (; i <= start; i++) {
                ans[i] = intervals[i];
            }
            for (int j = end; j < intervals.length; j++) {
                ans[i++] = intervals[j];
            }
            return ans;
        } else {
            intervals[end][0] = newInterval[0];
            int i = 0;
            int[][] ans = new int[intervals.length - (end - start - 1)][2];
            for (; i <= start; i++) {
                ans[i] = intervals[i];
            }
            for (int j = end; j < intervals.length; j++) {
                ans[i++] = intervals[j];
            }
            return ans;
        }

    }

}
