package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P168 {
    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(702));
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(52));
    }

//    public static String convertToTitle(int n) {
//        if (n <= 0) return "";
//        List<Integer> res = new ArrayList<>();
//        convert(n, res);
////        System.out.println(res);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < res.size(); i++) {
//            if ((i + 1) < res.size() && res.get(i + 1) == 0) {
//                if (res.get(i) > 1) {
//                    sb.append((char) ('A' + res.get(i) - 1 - 1));
//                }
//                sb.append('Z');
//                i++;
//
//            } else {
//                sb.append((char) ('A' + res.get(i) - 1));
//            }
//        }
//        return sb.toString();
//    }
//
//    public static void convert(int n, List<Integer> res) {
//        if (n == 0) return;
//        convert(n / 26, res);
//        res.add(n % 26);
//
//    }


    public static String convertToTitle(int n) {
        if (n == 0) return "";
        return convertToTitle((n - 1) / 26) + ((char) ('A' + (n - 1) % 26));
    }
}
