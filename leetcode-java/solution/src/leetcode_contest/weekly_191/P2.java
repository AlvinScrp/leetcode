package leetcode_contest.weekly_191;

import java.util.Arrays;

public class P2 {

    public static void main(String[] args) {
        System.out.println();

    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hSplit = getSplit(horizontalCuts, h);
        int vSplit = getSplit(verticalCuts, w);
        return (int) ((1L * hSplit * vSplit) % (1000000000 + 7));

    }

    private int getSplit(int[] cuts, int maxCut) {
        int maxSplit = 0;
        for (int i = 0; i < cuts.length - 1; i++) {
            maxSplit = Math.max(cuts[i + 1] - cuts[i], maxSplit);
        }

        maxSplit = Math.max(cuts[0] - 0, maxSplit);
        maxSplit = Math.max(maxCut - cuts[cuts.length - 1], maxSplit);
        return maxSplit % (1000000000 + 7);
    }


}
