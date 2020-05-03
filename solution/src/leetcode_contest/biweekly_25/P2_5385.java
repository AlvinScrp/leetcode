package leetcode_contest.biweekly_25;

public class P2_5385 {

    public static void main(String[] args) {
        System.out.println(new P2_5385().maxDiff(555));
        System.out.println(new P2_5385().maxDiff(9));
        System.out.println(new P2_5385().maxDiff(123456));
        System.out.println(new P2_5385().maxDiff(10000));
        System.out.println(new P2_5385().maxDiff(9288));

    }

    public int maxDiff(int num) {
        int a = getA(num);
        int b = getB(num);
        return a - b;

    }


    private int getA(int num) {
        String aStr = String.valueOf(num);
        int x = -1;
        for (int i = 0; i < aStr.length(); i++) {
            int c = aStr.charAt(i) - '0';
            if (c != 9) {
                x = c;
                break;
            }
        }
        if (x != -1) {
            aStr = aStr.replace(String.valueOf(x), "9");
            return Integer.parseInt(aStr);
        } else {
            return num;
        }

    }

    private int getB(int num) {
        String aStr = String.valueOf(num);
        int x = -1;

        int start = aStr.charAt(0) - '0';
        if (start != 1) {
            aStr = aStr.replace(String.valueOf(start), "1");
            return Integer.parseInt(aStr);
        }

        for (int i = 1; i < aStr.length(); i++) {
            int c = aStr.charAt(i) - '0';
            if (c != 0 && c != 1) {
                x = c;
                break;
            }
        }
        if (x != -1) {
            aStr = aStr.replace(String.valueOf(x), "0");
            return Integer.parseInt(aStr);
        } else {
            return num;
        }
    }
}
