package leetcode;

public class P8_StringToInteger_atoi {
    public static void main(String[] args) {


        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
//        System.out.println(reverse(-123456789));
    }


    private static int myAtoi(String str) {
        str = str.trim();
        if(str.length()==0){
            return 0;
        }
        char start = str.charAt(0);
        int flag = 1;
        if (start == '+') {
            str = str.substring(1);
        } else if (start == '-') {
            flag = -1;
            str = str.substring(1);
        } else if (start >= '0' && start <= '9') {

        } else {
            return 0;
        }
        int r = 0;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char val = str.charAt(i);
            if (val < '0' || val > '9') {
                break;
            }
            int value = (val - '0') * flag;
            if (r > Integer.MAX_VALUE / 10 || (r == Integer.MAX_VALUE / 10 && value > 7)) return Integer.MAX_VALUE;
            if (r < Integer.MIN_VALUE / 10 || (r == Integer.MIN_VALUE / 10 && value < -8)) return Integer.MIN_VALUE;
            r = r * 10 + value;
        }
        return r;
    }
}
