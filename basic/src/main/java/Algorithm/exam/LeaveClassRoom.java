package Algorithm.exam;

import java.util.*;

/**
 * @author Lucas
 * @date 2019/8/24 20:15
 */
public class LeaveClassRoom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, ArrayList<Integer>> boyMap = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> girlMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int boy = sc.nextInt();
            int girl = sc.nextInt();
            if (boyMap.containsKey(boy)){
                boyMap.get(boy).add(girl);
            }else {
                ArrayList<Integer> girls = new ArrayList<Integer>(){{add(girl);}};
                boyMap.put(boy, girls);
            }
            if (girlMap.containsKey(girl)){
                girlMap.get(girl).add(boy);
            }else {
                ArrayList<Integer> boys = new ArrayList<Integer>(){{add(boy);}};
                girlMap.put(girl, boys);
            }
        }
        /*System.out.println(boyMap.size());
        for (int boy:boyMap.keySet()) {
            System.out.println(boy);
        }*/
        int count = 0;
        ArrayList<Integer> who = new ArrayList<>();
        while (true) {
            int boy = findMax(boyMap);
            int girl = findMax(girlMap);
            int kill = boyMap.get(boy).size() >= girlMap.get(girl).size() ? boy : girl;
            who.add(kill);
            count++;
            if (boyMap.containsKey(kill)){
                boyMap.remove(kill);
            }else {
                for (int b:boyMap.keySet()) {
                    if (boyMap.get(b).contains(kill)){
                        boyMap.get(b).remove((Integer) kill);
                    }
                }
            }
            if (girlMap.containsKey(kill)){
                girlMap.remove(kill);
            }else {
                for (int g:girlMap.keySet()) {
                    if (girlMap.get(g).contains(kill)){
                        girlMap.get(g).remove((Integer)kill);
                    }
                }
            }
            // 检查
            if (check(boyMap)&&check(girlMap)) break;
        }
        System.out.println(count);
        Collections.sort(who);
        for (int p:who) {
            System.out.println(p);
        }

    }

    // 找到当前map中对应人数最多的boy/girl
    static int findMax(HashMap<Integer, ArrayList<Integer>> map){
        int num = -1;
        int person = 0;
        for (int who:map.keySet()) {
            if (num < map.get(who).size()){
                num = map.get(who).size();
                person = who;
            }
        }
        return person;
    }

    // 检查是否为空
    static boolean check(HashMap<Integer, ArrayList<Integer>> map){
        if (map.size()==0){
            return true;
        }
        for (int person:map.keySet()) {
            if (map.get(person).size()!=0){
                return false;
            }
        }
        return true;
    }
}
