package leetcode.bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class P784 {

    public static void main(String[] args) {
        System.out.println(new P784().letterCasePermutation("a1b2"));
        System.out.println(new P784().letterCasePermutation("12345"));
    }

    public List<String> letterCasePermutation(String S) {

        List<String> res = new ArrayList<>();
        if (S == null || S.length() == 0) return res;
        S=S.toLowerCase();

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) count++;
        }

        int max = (1 << count) - 1;

        for (int num = 0; num <= max; num++) {
            StringBuilder sb = new StringBuilder();
            int b = count-1;
            for (int j = 0; j < S.length(); j++) {
                char ch = S.charAt(j);
                if (Character.isLetter(ch)) {
                    sb.append((num & (1 << b)) > 0 ? ((char) (ch - 32)) : ch);
                    b--;
                } else {
                    sb.append(ch);
                }
            }
            res.add(sb.toString());
        }
        return res;

    }

//    public List<String> letterCasePermutation(String S) {
//
//        List<String> res = new ArrayList<>();
//        if (S == null || S.length() == 0) return res;
//        S = S.toLowerCase();
//
//        int max = (1 << S.length()) - 1;
//        int diff = 'A' - 'a';
//
//        for (int num = 0; num <= max; num++) {
//            StringBuilder sb = new StringBuilder();
//            boolean needAdd = true;
//            for (int j = 0; j < S.length(); j++) {
//                int mask = 1 << (S.length() - 1 - j);
//
//                char ch = S.charAt(j);
//                if (ch >= '0' && ch <= '9') {
//                    if ((num & mask) > 0) {
//                        needAdd = false;
//                        break;
//                    }
//                    sb.append(ch);
//                } else if (ch >= 'a' && ch <= 'z') {
//                    sb.append((num & mask) > 0 ? ((char) (ch + diff)) : ch);
//                }
//            }
//            if (needAdd) {
//                res.add(sb.toString());
//            }
//
//        }
//        return res;
//
//    }
}
