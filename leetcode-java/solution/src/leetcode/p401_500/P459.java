package leetcode.p401_500;

public class P459 {

    public static void main(String[] args) {
        System.out.println(new P459().repeatedSubstringPattern("a"));
        System.out.println(new P459().repeatedSubstringPattern("aba"));
        System.out.println(new P459().repeatedSubstringPattern("abcabc"));
        System.out.println(new P459().repeatedSubstringPattern("abcabca"));
    }

    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
//        for (int i = 1; i < s.length(); i++) {
//            if (repeate(s, i)) return true;
//        }
//        return false;

    }

    private boolean repeate(String s, int subLength) {
        if (s.length() % subLength != 0) return false;
        int count = s.length() / subLength;
        for (int i = 1; i < count; i++) {
            for (int j = 0; j < subLength; j++) {
                if (s.charAt(i * subLength + j) != s.charAt(j)) return false;
            }
        }
        return true;
    }


}
