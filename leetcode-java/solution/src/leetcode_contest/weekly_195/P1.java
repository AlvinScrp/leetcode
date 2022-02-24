package leetcode_contest.weekly_195;

import java.util.*;

public class P1 {

    public static void main(String[] args) {
        System.out.println(isPathCrossing("NES"));
        System.out.println(isPathCrossing("NESWW"));
    }


    /**
     * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
     * <p>
     * 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
     *
     * @param path
     * @return
     */
    public static boolean isPathCrossing(String path) {


        Set<Long> points = new HashSet<>();
        long point = 0l;
        points.add(0l);

        for (int i = 0; i < path.length(); i++) {

            char ch = path.charAt(i);
            long newPoint =point ;
            if (ch == 'N') {//y+1
                newPoint = point + 1;
            } else if (ch == 'S') { //y-1
                newPoint = point - 1;

            } else if (ch == 'E') {//x+1
                newPoint = point + 100000;

            } else if (ch == 'W') {//x-1
                newPoint = point - 100000;
            }

//            System.out.println(newPoint);

//            if(newPoint<0) return false;
            if(points.contains(newPoint)) return true;
            points.add(newPoint);

        }
        return false;


    }


}
