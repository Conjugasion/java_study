package Algorithm.seach;

import java.util.*;


/**
 * @author Lucas
 * @date 2019-08-08 20:18
 * 已知两个单词，startword和endword，一个单词词典，每一次转换都要在词典中
 * 根据转换规则计算从start单次到end单次的最少转换步数
 * 若无法转换到end，返回0
 * hit -> cog, wordList=[hot, dot,dog,lot,log,cog];
 *
 * 宽度优先搜索
 */
public class WordStep {
    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(words));
        int step = adderLength("hit", "cot", wordList);
        System.out.println("需要转换" + step + "步");
    }

    // 邻接表， (String word, 与word仅相差一个字母的单词)
    static int adderLength(String start, String end, ArrayList<String> wordList){
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        HashSet<Character> startChars = new HashSet<>();
        for (int j = 0; j < start.length(); j++) {
            startChars.add(start.charAt(j));
        }

        // 求从start经过一次变换能变成的在字典中的word
        for (String s:wordList) {
            HashSet<Character> wordChars = new HashSet<>();
            for (int j = 0; j < s.length(); j++) {
                wordChars.add(s.charAt(j));
            }
            wordChars.removeAll(startChars);     // 求差集
            if (wordChars.size()==1){
                if (map.containsKey(start)){
                    map.get(start).add(s);
                }else {
                    map.put(start, new ArrayList<String>(){{add(s);}});
                }
            }
        }

        // 求字典中的各个word间经过一次变换能变成的word
        for (String s:wordList) {
            HashSet<Character> wordChars1 = new HashSet<>();
            for (int j = 0; j < s.length(); j++) {
                wordChars1.add(s.charAt(j));
            }
            for (String ss:wordList) {
                HashSet<Character> wordChars2 = new HashSet<>();
                for (int j = 0; j < ss.length(); j++) {
                    wordChars2.add(ss.charAt(j));
                }
                wordChars2.removeAll(wordChars1);     // 求差集
                if (wordChars2.size()==1){
                    if (map.containsKey(s)){
                        map.get(s).add(ss);
                    }else {
                        map.put(s, new ArrayList<String>(){{add(ss);}});
                    }
                }
            }
        }
        System.out.println(map);

        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{start, 0});               // [节点， 计数]
        HashSet<String> hasVisit = new HashSet<>();    // 记录已经访问过的节点

        while (!q.isEmpty()){
            Object[] word = q.poll();
            hasVisit.add(String.valueOf(word[0]));

            if (word[0]==end){
                return (int)word[1];
            }

            ArrayList<String> list = map.get(String.valueOf(word[0]));
            for (String s:list) {
                if (!hasVisit.contains(s)){            // 未访问过的节点才能加入队列
                    q.offer(new Object[]{s, (int)word[1]+1});
                }
            }
        }
        return 0;
    }
}
