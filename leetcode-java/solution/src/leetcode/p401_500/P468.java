package leetcode.p401_500;

import java.math.BigDecimal;

public class P468 {
//    输入：IP = "172.16.254.1"
//    输出："IPv4"
//    解释：有效的 IPv4 地址，返回 "IPv4"
//    示例 2：
//
//    输入：IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
//    输出："IPv6"
//    解释：有效的 IPv6 地址，返回 "IPv6"
//    示例 3：
//
//    输入：IP = "256.256.256.256"
//    输出："Neither"
//    解释：既不是 IPv4 地址，又不是 IPv6 地址
//    示例 4：
//
//    输入：IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:"
//    输出："Neither"
//    示例 5：
//
//    输入：IP = "1e1.4.5.6"
//    输出："Neither"

    public static void main(String[] args) {
        System.out.println("1.2.".split("\\.").length);
        System.out.println("1.2.".endsWith("."));
        System.out.println(new P468().validIPAddress( "1.1.1.1."));
        System.out.println(new P468().validIPAddress( "172.16.254.1"));
        System.out.println(new P468().validIPAddress( "256.256.256.256"));
        System.out.println(new P468().validIPAddress( "1e1.4.5.6"));
        System.out.println(new P468().validIPAddress( "2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }

    public String validIPAddress(String IP) {
        if (isIPv4(IP)) return "IPv4";
        if (isIPv6(IP)) return "IPv6";
        return "Neither";

    }

    private boolean isIPv4(String ip) {
        if (ip.startsWith(".") || ip.endsWith(".")) return false;
        String[] ss = ip.split("\\.");
        if (ss.length != 4) return false;
        for (String s : ss) {
            try {
                if (s.length() > 1 && s.startsWith("0")) return false;
                if(s.length()>3) return false;
                int num = Integer.parseInt(s);
                if (num < 0 || num > 255) return false;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    private boolean isIPv6(String ip) {
        if (ip.startsWith(":") || ip.endsWith(":")) return false;
        String[] ss = ip.split(":");
        if (ss.length != 8) return false;
        for (String s : ss) {
            if(s.length()>4) return false;
            try {
                Integer.parseInt(s,16);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}
