package leetcode.p401_500;

public class P415 {
    public static void main(String[] args) {
//        new P415().addStrings("9","99");
        new P415().addStrings("0","0");
    }

    public String addStrings(String num1, String num2) {
        if(num1.equals("0")&&num2.equals("0")) return "0";

        int l1 = num1.length(), l2 = num2.length();
        if (l1 == 0 || l2 == 0) return "0";
        int[] ans = new int[Math.max(l1, l2) + 1];

        int k = ans.length - 1;
        int ch1, ch2, sum;
        for (int i = l1 - 1, j = l2 - 1; i >= 0 || j >= 0; i--, j--, k--) {
            ch1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            ch2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            sum = ch1 + ch2 + ans[k];
            ans[k] = sum % 10;
            ans[k - 1] += sum / 10;
        }

        int i = 0;
        for (; ans[i] == 0; i++) ;
        StringBuilder sb = new StringBuilder(l1 + l2);
        for (int j = i; j < ans.length; j++) {
            sb.append(ans[j]);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
