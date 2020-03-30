import java.util.ArrayList;
import java.util.List;

public class P6_ZStringConvert {

    public static void main(String[] args) {

//        System.out.println(convert("LEETCODEISHIRING",2));
//        System.out.println(convert("abcdecfghijk",2));
//        System.out.println(convert("LEETCODEISHIRING",4).equals("LDREOEIIECIHNTSG"));

    }

//    public static String convert(String s, int numRows) {
//        int groupSize = 2 * numRows - 2;
//
//        int maxColumn = numRows;
//        int maxRows = ((s.length() + groupSize - 1) / groupSize) * (numRows - 1);
//
//        char[][] chars = new char[maxRows][maxColumn];
//
//        for (int index = 0; index < s.length(); index++) {
//            int rowBase = index / groupSize * (numRows - 1);
//            int newIndex = index % groupSize;
//            int row = rowBase + Math.max(0, newIndex + 1 - numRows);
//            int column = newIndex <= (numRows - 1) ? newIndex : ((numRows - 2) - (newIndex % numRows));
//            chars[row][column]=s.charAt(index);
//
//            System.out.println("index,row,column:"+index+","+row+","+column+","+String.valueOf(s.charAt(index)));
//        }
//        StringBuffer sb=new StringBuffer();
//
//        for (int i = 0; i < maxColumn; i++) {
//            for (int j = 0; j < maxRows; j++) {
//                char item= chars[j][i];
//                if (item>0){
//                    sb.append(item);
//                }
//                System.out.print(String.valueOf(item)+"  ");
//
//            }
//            System.out.println("");
//        }
////        for (int i = 0; i < maxRows; i++) {
////            for (int j = 0; j < maxColumn; j++) {
////                char item= chars[i][j];
////                if (item>0){
////                    sb.append(item);
////                }
////                System.out.print(String.valueOf(item)+"  ");
////
////            }
////            System.out.println("");
////        }
//        return sb.toString();
//
//    }

//    public static String convert(String s, int numRows) {
//        if (s.length()==0||s.length()==1||numRows==0||numRows==1){
//            return s;
//        }
//        int groupSize = 2 * numRows - 2;
//        int maxColumn = numRows;
//        int maxRows = ((s.length() + groupSize - 1) / groupSize) * (numRows - 1);
//        char[][] chars = new char[maxRows][maxColumn];
//        for (int index = 0; index < s.length(); index++) {
//            int rowBase = index / groupSize * (numRows - 1);
//            int newIndex = index % groupSize;
//            int row = rowBase + Math.max(0, newIndex + 1 - numRows);
//            int column = newIndex <= (numRows - 1) ? newIndex : ((numRows - 2) - (newIndex % numRows));
//            chars[row][column]=s.charAt(index);
//        }
//        StringBuffer sb=new StringBuffer();
//        for (int i = 0; i < maxColumn; i++) {
//            for (int j = 0; j < maxRows; j++) {
//                char item= chars[j][i];
//                if (item>0){
//                    sb.append(item);
//                }
//            }
//        }
//        return sb.toString();
//
//    }

    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
