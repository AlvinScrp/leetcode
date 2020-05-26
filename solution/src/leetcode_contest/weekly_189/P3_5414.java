package leetcode_contest.weekly_189;

import java.util.*;

public class P3_5414 {

    //favoriteCompanies = [
    // ["leetcode","google","facebook"],
    // ["google","microsoft"],
    // ["google","facebook"],
    // ["google"],
    // ["amazon"]]
    //输出：[0,1,4]
    //[["nxaqhyoprhlhvhyojanr","ovqdyfqmlpxapbjwtssm","qmsbphxzmnvflrwyvxlc","udfuxjdxkxwqnqvgjjsp","yawoixzhsdkaaauramvg","zycidpyopumzgdpamnty"],
    // ["nxaqhyoprhlhvhyojanr","ovqdyfqmlpxapbjwtssm","udfuxjdxkxwqnqvgjjsp","yawoixzhsdkaaauramvg","zycidpyopumzgdpamnty"],
    // ["ovqdyfqmlpxapbjwtssm","qmsbphxzmnvflrwyvxlc","udfuxjdxkxwqnqvgjjsp","yawoixzhsdkaaauramvg","zycidpyopumzgdpamnty"]]
    public static void main(String[] args) {
        List<List<String>> favoriteCompanies = new ArrayList<>();
        favoriteCompanies.add(Arrays.asList("nxaqhyoprhlhvhyojanr","ovqdyfqmlpxapbjwtssm","qmsbphxzmnvflrwyvxlc","udfuxjdxkxwqnqvgjjsp","yawoixzhsdkaaauramvg","zycidpyopumzgdpamnty"));
        favoriteCompanies.add(Arrays.asList("nxaqhyoprhlhvhyojanr","ovqdyfqmlpxapbjwtssm","udfuxjdxkxwqnqvgjjsp","yawoixzhsdkaaauramvg","zycidpyopumzgdpamnty"));
        favoriteCompanies.add(Arrays.asList("ovqdyfqmlpxapbjwtssm","qmsbphxzmnvflrwyvxlc","udfuxjdxkxwqnqvgjjsp","yawoixzhsdkaaauramvg","zycidpyopumzgdpamnty"));

        System.out.println(new P3_5414().peopleIndexes(favoriteCompanies));

    }

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {

        for (List<String> favoriteCompany : favoriteCompanies) {
            Collections.sort(favoriteCompany, (o1, o2) -> compareInner(o1, o2));
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> fI = favoriteCompanies.get(i);
            boolean containsed = false;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                List<String> fJ = favoriteCompanies.get(j);
                if (j != i && aContainB(fJ, fI)) {
                    containsed = true;
                    break;
                }
            }
            if (!containsed) res.add(i);

        }
        return res;
    }

    public boolean aContainB(List<String> listA, List<String> listB) {
        if (listA.size() < listB.size()) {
            return false;
        }
        int i, j;
        for (i = 0, j = 0; i < listA.size() && j < listB.size(); ) {
            String si = listA.get(i);
            String sj = listB.get(j);
            int compare = compareInner(si, sj);
            if (compare == 0) {
                i++;
                j++;
            } else if (compare < 0) {
                i++;
            } else if (compare > 0) {
                break;
            }

        }
        return j == listB.size();
    }

    public int compareInner(String o1, String o2) {
        char[] chars1 = o1.toCharArray();
        char[] chars2 = o2.toCharArray();
        for (int i = 0; i < chars1.length && i < chars2.length; i++) {
            if (chars1[i] < chars2[i]) return -1;
            else if (chars1[i] > chars2[i]) return 1;
        }
        return chars1.length - chars2.length;
    }
}
