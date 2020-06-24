package leetcode_contest.weekly_192;

import java.util.ArrayList;
import java.util.List;

public class P3 {

    public static void main(String[] args) {
        System.out.println(new P3());
    }


    class BrowserHistory {
        List<String> histories;
        int index;

        public BrowserHistory(String homepage) {
            histories = new ArrayList<>();
            histories.add(homepage);
            index = 0;
        }

        public void visit(String url) {

            int maxIndex=histories.size()-1;
            for (int i = maxIndex; i > index; i--) {
                histories.remove(i);
            }
            histories.add(url);
            index = histories.size() - 1;

        }

        public String back(int steps) {

            index = Math.max(index - steps, 0);
            return histories.get(index);

        }

        public String forward(int steps) {
            index = Math.min(index + steps, histories.size() - 1);
            return histories.get(index);
        }
    }
}
