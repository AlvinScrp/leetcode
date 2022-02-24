package leetcode_jianzhioffer;

public class J05 {


//    public String replaceSpace(String s) {
//        if(s==null||s.equals("")) return s;
//        StringBuilder sb=new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i)==' '){
//                sb.append("%20");
//            }else {
//                sb.append(s.charAt(i));
//            }
//        }
//        return sb.toString();
//    }

    public String replaceSpace(String s) {
        if(s==null||s.equals("")) return s;
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==' '){
                count+=2;
            }
        }
        char[] chars=new char[s.length()+count];
        int length=chars.length;
        for (int i = s.length()-1,j=length-1; i >=0; i--) {
            if(s.charAt(i)==' '){
                chars[j--]='0';
                chars[j--]='2';
                chars[j--]='%';
            }else {
                chars[j--]=s.charAt(i);
            }
        }
        return new String(chars);
    }

}
