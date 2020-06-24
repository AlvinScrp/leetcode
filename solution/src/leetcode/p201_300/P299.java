package leetcode.p201_300;

public class P299 {

    public static void main(String[] args) {
        getHint("1807", "7810");
        getHint("1123", "0111");
        getHint("11", "10");
    }

//    输入: secret = "1807", guess = "7810"
//    输出: "1A3B"
//    解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
//    示例 2:
//
//    输入: secret = "1123", guess = "0111"
//    输出: "1A1B"
//    解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。


//    public static String getHint(String secret, String guest) {
//
//        int countA = 0;
//        int count = 0;
//
//        int[] checkedS = new int[secret.length()];
//        int[] checkedG = new int[secret.length()];
//
//        for (int i = 0; i < secret.length(); i++) {
//            if (guest.charAt(i) == secret.charAt(i)) {
//                checkedS[i] = 1;
//                checkedG[i] = 1;
//                countA++;
//                count++;
//            }
//        }
//
//        for (int i = 0; i < secret.length(); i++) {
//            char cs = secret.charAt(i);
//            if (checkedS[i] == 1) continue;
//            for (int j = 0; j < guest.length(); j++) {
//                if (checkedG[j] != 1 && cs == guest.charAt(j)) {
//                    count++;
//                    checkedS[i] = 1;
//                    checkedG[j] = 1;
//                    break;
//                }
//            }
//        }
//        String ans = countA + "A" + (count - countA) + "B";
////        System.out.println(ans);
//        return ans;
//
//    }


    public static String getHint(String secret, String guest) {
        int countA = 0;
        int[] b = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char cs = secret.charAt(i);
            char cg = guest.charAt(i);

            if (cs == cg) {
                countA++;
                continue;
            }
            b[cs - '0']++;
            b[cg - '0']--;
        }
        int failCount = 0;
        for (int i : b) {
            if (i > 0) failCount += i;

        }
        int countB = secret.length() - failCount - countA;
        String ans = countA + "A" + countB + "B";
//        System.out.println(ans);
        return ans;

    }


}
