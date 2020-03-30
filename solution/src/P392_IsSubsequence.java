public class P392_IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));

    }

    public static boolean isSubsequence(String s, String t) {
        int sp = 0, tp = 0;
        int sl = s.length(), tl = t.length();
        if(sl==0){
            return true;
        }
        while (sp < sl && tp < tl) {
            if (s.charAt(sp) == t.charAt(tp)) {
                if (sp == sl - 1) {
                    return true;
                }
                sp++;

            }
            tp++;

        }
        return false;

    }
}
