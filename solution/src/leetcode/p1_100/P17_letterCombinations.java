package leetcode.p1_100;

import java.util.*;

public class P17_letterCombinations {

    public static void main(String[] args) {
        letterCombinations("23").stream().forEach(System.out::println);

    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if(digits.length()==0){
            return res;
        }
        Map<Character, List<Character>> dlMap = new HashMap<>();
        dlMap.put('2', Arrays.asList('a', 'b', 'c'));
        dlMap.put('3', Arrays.asList('d', 'e', 'f'));
        dlMap.put('4', Arrays.asList('g', 'h', 'i'));
        dlMap.put('5', Arrays.asList('j', 'k', 'l'));
        dlMap.put('6', Arrays.asList('m', 'n', 'o'));
        dlMap.put('7', Arrays.asList('p', 'q', 'r', 's'));
        dlMap.put('8', Arrays.asList('t', 'u', 'v'));
        dlMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        StringBuilder paths = new StringBuilder();

        backTrack(digits, 0, paths, res, dlMap);
        return res;

    }

    private static void backTrack(String digits, int index, StringBuilder paths, List<String> res, Map<Character, List<Character>> dlMap) {
        if (index == digits.length()) {
            res.add(paths.toString());
            return;
        }
        List<Character> letters = dlMap.get(digits.charAt(index));
        for (Character letter : letters) {
            paths.append(letter);
            backTrack(digits, index + 1, paths, res, dlMap);
            paths.deleteCharAt(paths.length() - 1);
        }
    }
}


/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
