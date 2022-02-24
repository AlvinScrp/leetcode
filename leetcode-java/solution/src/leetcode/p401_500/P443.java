package leetcode.p401_500;

public class P443 {

    public static void main(String[] args) {

        System.out.println(new P443().compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c',}));

    }

//    输入： ["a","a","b","b","c","c","c"]
//    输出：返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
//    说明："aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。

    public int compress(char[] chars) {
        char current = '!';
        int count = 0;
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == current) {
                count++;
            } else {
                j += fillArray(chars, j, current, count);
                current = aChar;
                count = 1;
            }
        }
        j += fillArray(chars, j, current, count);
//        System.out.println(Arrays.toString(chars));
        return j;
    }

    private int fillArray(char[] chars, int start, char current, int count) {
        if (count == 0) return 0;
        String str = String.valueOf(current);
        if (count > 1) str += String.valueOf(count);
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            chars[i + start] = charArray[i];
        }
        return charArray.length;

    }
}
