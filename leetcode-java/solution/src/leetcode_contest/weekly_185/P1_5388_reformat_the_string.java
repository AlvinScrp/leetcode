package leetcode_contest.weekly_185;

public class P1_5388_reformat_the_string {

    public static void main(String[] args) {
        System.out.println(reformat("covid2019"));
        System.out.println(reformat("ab123"));
        System.out.println(reformat("a0b1c2"));

    }

    /**
     * 输入：s = "covid2019"
     * 输出："c2o0v1i9d"
     *
     * @param s
     * @return
     */
    public static String reformat(String s) {
        char[] chars = s.toCharArray();

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder res = new StringBuilder();

        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9') {
                sb1.append(aChar);
            } else {
                sb2.append(aChar);
            }
        }
        if (Math.abs(sb1.length() - sb2.length()) > 1) {
            return "";
        }

        int i = 0;
        int j = 0;
        if (sb1.length() < sb2.length()) {
            StringBuilder temp = sb1;
            sb1 = sb2;
            sb2 = temp;
        }
        while (i < sb1.length() && j < sb2.length()) {

            res.append(sb1.charAt(i));
            i++;
            res.append(sb2.charAt(j));
            j++;
        }

        res.append(i < sb1.length() ? sb1.substring(i) : (j < sb2.length() ? sb2.substring(j) : ""));

        return res.toString();


    }


}
