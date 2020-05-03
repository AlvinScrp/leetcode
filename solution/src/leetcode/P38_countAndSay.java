package leetcode;

public class P38_countAndSay {

    public static void main(String[] args) {
        countAndSay(5);
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String last = countAndSay(n - 1);
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < last.length(); ) {
            int j = 1;
            while (i + j < last.length() && last.charAt(i) == last.charAt(i + j)) {
                j++;
            }
            current.append(j);
            current.append(last.charAt(i));
            i += j;
        }
//        System.out.println(current.toString());
        return current.toString();
    }


}
