package Algorithm.offer;

/**
 * @author Lucas
 * @date 2019-06-19 20:36
 * 字符串全排列
 */
public class QuanPaiLie {
    public static void main(String[] args) {
        String[] str = {"a", "b", "c", "d", "a"};
        pailie(str, 0, 4);
    }

    // 带重复数字 递归版
    static void pailie(String[] str, int from, int to){
        if (from == to) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i <= to; i++) {
                s.append(str[i]);
            }
            System.out.println(s);
        }
        for (int i = from; i <= to; i++) {
            boolean isSwap = true;
            for (int j = from; j < i; j++) {
                if (str[j] == str[i]){
                    isSwap = false;
                }
            }
            if (isSwap){
                String s1 = str[i];
                str[i] = str[from];
                str[from] = s1;
                pailie(str, from+1, to);
                String s2 = str[i];
                str[i] = str[from];
                str[from] = s2;
            }
        }
    }

}
