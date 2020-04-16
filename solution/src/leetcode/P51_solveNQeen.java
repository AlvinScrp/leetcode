package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class P51_solveNQeen {
    public static void main(String[] args) {
        solveNQueens(4).stream().forEach(System.out::println);
    }

    public static List<List<String>> solveNQueens(int n) {

        List<List<Point>> res = new ArrayList<>();
        LinkedList<Point> paths = new LinkedList<>();
        LinkedList<Integer> ys = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            ys.add(i);
        }
        dfs(n, 0, ys, paths, res);
        List<List<String>> results = pointToString(n, res);
        return results;


    }

    private static List<List<String>> pointToString(int n, List<List<Point>> res) {
        List<List<String>> results = new ArrayList<>();
        for (List<Point> points : res) {
            List<String> strs = new ArrayList<>();
            for (Point point : points) {
                StringBuilder sb = new StringBuilder(n);
                for (int y = 0; y < n; y++) {
                    sb.append(y == point.y ? 'Q' : '.');
                }
                strs.add(sb.toString());

            }
            results.add(strs);
        }
        return results;
    }


    private static void dfs(int n, int x, List<Integer> ys, LinkedList<Point> paths, List<List<Point>> res) {

        if (x == n) {
            res.add(new LinkedList<>(paths));
            return;
        }
        for (int i = 0; i < ys.size(); i++) {
            Point point = new Point(x, ys.get(i));
            if (isValid(n, point, paths)) {
                List<Integer> ysCopy = ys.stream().filter(y -> y != point.y).collect(Collectors.toList());
                paths.add(point);
                dfs(n, x + 1, ysCopy, paths, res);
                paths.remove(point);

            }
        }
    }

    private static boolean isValid(int n, Point point, LinkedList<Point> paths) {
        int x = point.x - 1, y = point.y - 1;
        while (x >= 0 && y >= 0) {
            if (paths.contains(new Point(x, y))) {
                return false;
            }
            x--;
            y--;
        }
        x = point.x - 1;
        y = point.y + 1;
        while (x >= 0 && y < n) {
            if (paths.contains(new Point(x, y))) {
                return false;
            }
            x--;
            y++;
        }

        return true;
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }
    }


}
