package algorithm.offer;

/**
 * @author Lucas
 * @date 2019-06-19 21:59
 */
public class KMP {
    public static void main(String[] args) {
        System.out.println();
    }

    // 暴力搜索 查找source种target首次出现的位置
    static int find(int[] source, int[] target){
        int s = source.length;
        int t = target.length;
        int i = 0;
        int j = 0;
        while (i < s && j < t){
            if (source[i] == target[j]){
                i++;
                j++;
            }
            else {
                i++;
                j=0;
            }
        }
        if (j == target.length){
            return i;
        }
        else return -1;
    }

    //
}
