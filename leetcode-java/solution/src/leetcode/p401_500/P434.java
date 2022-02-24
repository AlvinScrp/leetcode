package leetcode.p401_500;

public class P434 {

    public static void main(String[] args) {
        System.out.println(new P434().countSegments(" Hello, my name is John "));
        System.out.println(new P434().countSegments(" He1llo, my name is John "));
        System.out.println(new P434().countSegments("Hello, my name is John"));

        System.out.println(Character.isLetter(','));

    }

    public int countSegments(String s) {
        int count = 0;
        boolean start = false;
        for (int i = 0; i < s.length(); i++) {
            boolean isLetter = !Character.isSpaceChar(s.charAt(i));
            if (isLetter) {
                if (!start) start = true;
            } else {
                if (start) {
                    count++;
                    start = false;
                }
            }
        }
        return count + (start ? 1 : 0);

    }
}
