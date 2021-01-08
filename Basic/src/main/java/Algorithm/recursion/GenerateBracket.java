package Algorithm.recursion;

import java.util.ArrayList;

/**
 * @author Lucas
 * @date 2019-08-04 12:55
 * 生成括号，已知n组括号，生成这n组括号所有合法的组合可能
 * n=3
 * [((())), (()()), (())(), ()(()),()()()]
 * 2^2n种可能
 */
public class GenerateBracket {
    public static void main(String[] args) {
        int n = 3;
        ArrayList<String> result = new ArrayList<>();
        allSet(n, n, "", result);
        System.out.println(result);
    }

    // 找到所有的组合情况
    // n为组数，item是括号字符串， result保存所有结果, x是当前可以放(的数量，y是当前可以放)的数量
    // 只有放了左括号，才能放右括号
    // 剩余可放的左括号数量 < 剩余可放的右括号数量，才可进行右括号放置
    static void allSet(int x, int y, String item, ArrayList<String> result) {
        if (x==0&&y==0){
            result.add(item);
            return;
        }
        if (x>0){
            allSet(x-1, y, item+"(", result);
        }
        if (x<y){
            allSet(x, y-1, item+")", result);
        }
    }
}
