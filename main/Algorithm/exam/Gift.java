package Algorithm.exam;

import java.util.*;

/**
 * @author Lucas
 * @date 2019/9/11 21:23
 */
public class Gift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        ArrayList<ArrayList<Integer>> jia = new ArrayList<>();
        ArrayList<ArrayList<Integer>> yi = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> person = new ArrayList<>();
            int one = sc.nextInt();
            int two = sc.nextInt();
            person.add(i+1);   // 哪一位客户
            person.add(one);   // 甲
            person.add(two);   // 乙
            if (one >= two){
                jia.add(person);
            }else {
                yi.add(person);
            }
        }
        Collections.sort(jia, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.get(1) - o2.get(2) - (o1.get(1) - o1.get(2));
            }
        });
        Collections.sort(yi, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.get(2) - o2.get(1) - (o1.get(2) - o1.get(1));
            }
        });
        //System.out.println(jia);
        //System.out.println(yi);
        int num = 0;
        ArrayList<ArrayList<Integer>> jiaCopy = new ArrayList<>(jia);
        ArrayList<ArrayList<Integer>> yiCopy = new ArrayList<>(yi);

        if (b>0){
            for (ArrayList<Integer> p:jia) {
                num += p.get(2);
                jiaCopy.remove(p);
                b--;
                if (b==0) break;
            }
        }
        if (a>0){
            for (ArrayList<Integer> p:yi) {
                num += p.get(1);
                yiCopy.remove(p);
                a--;
                if (a==0) break;
            }
        }
        if (jiaCopy.size()!=0){
            for (ArrayList<Integer> p:jiaCopy) {
                num += p.get(1);
                a--;
                if (a==0) break;
            }
        }
        if (yiCopy.size()!=0){
            for (ArrayList<Integer> p:yiCopy) {
                num += p.get(2);
                b--;
                if (b==0) break;
            }
        }
        System.out.println(num);
    }
}
