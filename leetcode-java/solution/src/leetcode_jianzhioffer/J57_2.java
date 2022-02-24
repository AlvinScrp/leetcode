package leetcode_jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J57_2 {
    public static void main(String[] args) {
        new J57_2().findContinuousSequence(98160);
    }

    /**
     * 输入：target = 9
     * 输出：[[2,3,4],[4,5]]
     *
     * @param target
     * @return
     */

//    public int[][] findContinuousSequence(int target) {
//
//        List<int[]> res = new ArrayList<>();
//        int i = 1, j = 2, sum = i + j, limit = (target + 1) >> 1;
//        while (i <= limit) {
//            if (sum > target) {
//                sum -= (i++);
//            } else {
//                if (sum == target) add(res, i, j);
//                sum += ++j;
//            }
//        }
//        return res.toArray(new int[res.size()][]);
//
//
//    }
//
//    private void add(List<int[]> res, int i, int j) {
//        int[] array = new int[j - i + 1];
//        for (int k = 0; k < array.length; k++) {
//            array[k] = i + k;
//        }
//        System.out.println(Arrays.toString(array));
//        res.add(array);
//    }
    //32719
    public int[][] findContinuousSequence(int target) {

        List<int[]> res = new ArrayList<>();
        int x = 32719, limit = (target + 1) >> 1;
        while (x <= limit) {
            long c = x - x * x - 2 * target;
            double sqrt = Math.sqrt(1 - 4 * c);
            double yDouble = (sqrt - 1) / 2;
            int y = (int) yDouble;
            if (isInt(yDouble) && y > x) {
                add(res, x, y);
            }
            x++;
        }
        return res.toArray(new int[res.size()][]);


    }

    public boolean isInt(double d) {
        return d - Math.floor(d) < 1e-10;
    }

    private void add(List<int[]> res, int i, int j) {
        int[] array = new int[j - i + 1];
        for (int k = 0; k < array.length; k++) {
            array[k] = i + k;
        }
        System.out.println(Arrays.toString(array));
        res.add(array);
    }

}
