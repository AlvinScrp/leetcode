import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P3_lengthOfLongestSubstring {


    public static void main(String[] args) {
        System.out.println("abcabcbb:"+lengthOfLongestSubstring("abcabcbb"));
        System.out.println("bbbbb:"+lengthOfLongestSubstring("bbbbb"));
        System.out.println("pwwkew:"+lengthOfLongestSubstring("pwwkew"));
        System.out.println(" :" + lengthOfLongestSubstring(" "));

    }

    /**
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (index[s.charAt(j)]>0) {
                i = index[s.charAt(j)];
            }
//            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }


//    public static int lengthOfLongestSubstring(String s) {
//        int longSubSize = 0;
//        byte[] bytes = s.getBytes();
//        int length = bytes.length;
//        if (length == 1 || length == 0) {
//            return length;
//        }
//        for (int p = 0; p < length - 1; p++) {
//            Set<Byte> set = new HashSet<>();
//            set.add(bytes[p]);
//            for (int q = p + 1; q < length; q++) {
//                byte last = bytes[q];
//                if (set.contains(last)) {
//                    break;
//                } else {
//                    set.add(last);
//                }
//            }
//            longSubSize = Math.max(longSubSize, set.size());
//        }
//
//        return longSubSize;
//
//    }
}

