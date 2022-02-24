package leetcode.p1_100;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class P71 {



//    输入："/home/"
//    输出："/home"
//
//    输入："/../"
//    输出："/"
//
//    输入："/home//foo/"
//    输出："/home/foo"
//
//    输入："/a/./b/../../c/"
//    输出："/c"
//
//    输入："/a/../../b/../c//.//"
//    输出："/c"



    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
//        System.out.println(Arrays.toString("a//b".split("/")));
    }

    public static String simplifyPath(String path) {

        String[] ss=path.split("/");

        Deque<String> deque=new LinkedList<>();

        for (String s : ss) {
            if(s.equals("")||s.equals(".")) continue;
            if(s.equals("..")) {
               if(!deque.isEmpty()) deque.removeLast();
            }else {
                deque.addLast(s);
            }
        }
        StringBuilder sb=new StringBuilder();

        if(deque.isEmpty()) sb.append("/");
        while (!deque.isEmpty()){
            sb.append("/");
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }
}
