package leetcode_contest.biweekly_30;

import java.util.HashMap;
import java.util.Map;

public class P1 {

    public static void main(String[] args) {
        System.out.println();

    }

//    Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
//    Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素

    public String reformatDate(String date) {

        Map<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");

        String[] strs = date.split(" ");

        String year = strs[2];
        String month = monthMap.get(strs[1]);

        int day = 0;
        String dayStr = strs[0];
        for (int i = 0; i < dayStr.length(); i++) {
            int temp = dayStr.charAt(i) - '0';
            if (temp >= 0 && temp <= 9) {
                day = day * 10 + temp;
            } else {
                break;
            }
        }

        dayStr = day < 10 ? ("0" + day) : ("" + day);

        return year + "-" + month + "-" + dayStr;


    }


}
