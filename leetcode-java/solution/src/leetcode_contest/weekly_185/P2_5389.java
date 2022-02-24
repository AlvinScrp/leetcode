package leetcode_contest.weekly_185;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class P2_5389 {

    public static void main(String[] args) {

    }

    /**
     * 输入：orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
     * 输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
     * 解释：
     * 点菜展示表如下所示：
     * Table,Beef Burrito,Ceviche,Fried Chicken,Water
     * 3    ,0           ,2      ,1            ,0
     * 5    ,0           ,1      ,0            ,1
     * 10   ,1           ,0      ,0            ,0
     * 对于餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
     * 而餐桌 5：Carla 点了 "Water" 和 "Ceviche"
     * 餐桌 10：Corina 点了 "Beef Burrito"
     */

    public static List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<Integer, TreeMap<String, Integer>> tableFoodMap = new TreeMap();

        TreeSet<String> foodNameSet = new TreeSet<>();
        for (List<String> order : orders) {

            String name = order.get(0);
            int table = Integer.parseInt(order.get(1));
            String food = order.get(2);
            foodNameSet.add(food);

            TreeMap<String, Integer> foodNumMap = tableFoodMap.get(table);
            if (foodNumMap == null) {
                foodNumMap = new TreeMap<>();
                tableFoodMap.put(table, foodNumMap);
            }
            int count = 1;
            if (foodNumMap.containsKey(food)) {
                count += foodNumMap.get(food);
            }
            foodNumMap.put(food, count);
        }


        List<List<String>> ress = new LinkedList<>();

        List<String> head = new LinkedList<>();
        head.add("Table");
        for (String foodName : foodNameSet) {
            head.add(foodName);
        }
        ress.add(head);

        tableFoodMap.forEach((table, foodNumMap) -> {
            List<String> res = new LinkedList<>();
            res.add(String.valueOf(table));
            for (String foodName : foodNameSet) {
                int num = foodNumMap.containsKey(foodName) ? foodNumMap.get(foodName) : 0;
                res.add(String.valueOf(num));
            }
            ress.add(res);
        });
        return ress;

    }

}
