package leetcode.bit_manipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P401 {

    public static void main(String[] args) {
        readBinaryWatch(1);
    }

    public static List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                if (countOne((hour << 6) + minute) == num) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(hour);
                    sb.append(":");
                    if (minute <= 9) sb.append(0);
                    sb.append(minute);
                    res.add(sb.toString());
                }
            }
        }
//        System.out.println(res);
        return res;
    }

    private static int countOne(int n) {
        int count = 0;
        for (; n > 0; count++) n = n & (n - 1);
        return count;
    }

    public static List<String> readBinaryWatch2(int num) {
        List<String> res = new ArrayList<>();
        if (num == 0) {
            convertAndAdd(res, 0x0);
            return res;
        } else if (num >= 9) {
            return res;
        }
        int[] masks = new int[10];
        masks[9] = 1;
        for (int i = 8; i >= 0; i--) {
            masks[i] = masks[i + 1] << 1;
        }
//        System.out.println(Arrays.toString(masks));
        dfs(num, -1, 0, res, masks);
//        System.out.println(res);
        return res;
    }

    private static void dfs(int num, int i, int value, List<String> res, int[] masks) {

        if (num == 0) {
            convertAndAdd(res, value);
            return;
        }
        for (int j = i + 1; j < 10; j++) {
            dfs(num - 1, j, value | masks[j], res, masks);
        }

    }

    private static void convertAndAdd(List<String> res, int value) {
        int hour = value >> 6;
        int minute = value & 0x3f;
        if (hour < 12 && minute < 60) {
            res.add(hour + ":" + (minute <= 9 ? ("0" + minute) : minute));
        }
    }
}
