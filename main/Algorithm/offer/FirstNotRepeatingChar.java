package algorithm.offer;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Lucas
 * @date 2019-07-14 14:27
 */
public class FirstNotRepeatingChar {
    public static void main(String[] args) {
        String str = "asdfasdq";
        int q = str.lastIndexOf('a');
        System.out.println("lastIndexOf: " + q);
        System.out.println(str.substring(0, 0).length()==0);
        System.out.println("FirstNotRepeatingChar: " + find(str));
    }

    static int find(String str){
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(char c:chars){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else {
                map.put(c,1);
            }
        }
        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        Iterator<Map.Entry<Character, Integer>> it = set.iterator();
        boolean flag = false;
        while (it.hasNext()){
            Map.Entry<Character, Integer> entry = it.next();
            char key = entry.getKey();
            int count = entry.getValue();
            if (count == 1) {
                for(int i=0;i < chars.length;i++){
                    if (key==chars[i]){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
