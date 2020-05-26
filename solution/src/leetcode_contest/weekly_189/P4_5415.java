package leetcode_contest.weekly_189;

import java.util.Arrays;

public class P4_5415 {

    public static void main(String[] args) {
      new P4_5415().numPoints(new int[][]{{1,2},{3,5},{1,-1},{2,3},{4,1},{1,3}},2);
      new P4_5415().numPoints(new int[][] {{-2,0},{2,0},{0,2},{0,-2}},2);
      new P4_5415().numPoints(new int[][]  {{-3,0},{3,0},{2,6},{5,4},{0,9},{7,8}},5);

    }

    public int numPoints(int[][] points, int r) {

        int[] edges = findEdges(points);
        System.out.println(Arrays.toString(edges));
        int max = 0;

        int[] res=new int[2];

        int rr = r * r;

        for (int x0 = edges[0]; x0 <= edges[1]; x0++) {

            for (int y0 = edges[3]; y0 <= edges[2]; y0++) {
                int count = 0;
                for (int[] point : points) {
                    if (pointInCircle(point, x0, y0, r, rr)) {
                        count++;
                    }
                }
                if(count>max){
                    res=new int[]{x0,y0};
                }
                max = Math.max(count, max);
            }
        }
        System.out.println(Arrays.toString(res)+" max:"+max);
        System.out.println("-------------");
        return max;

    }

    private boolean pointInCircle(int[] point, int x0, int y0, int r, int rr) {
        int x = point[0], y = point[1];
        if (x >= x0 - r && x <= x0 + r && y >= y0 - r && y <= y0 + r) {
            if (Math.abs((x - x0) * (x - x0)) + Math.abs((y - y0) * (y - y0)) <= rr) {
                return true;
            }
        }

        return false;
    }

    private int[] findEdges(int[][] points) {
        //left,top,right,bottom
        int l = 0, r = 1, t = 2,b = 3;

        int[] edges = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE};
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            edges[l] = Math.min(edges[l], x);
            edges[r] = Math.max(edges[r], x);

            edges[t] = Math.max(edges[t], y);
            edges[b] = Math.min(edges[b], y);
        }
        return edges;
    }
}
