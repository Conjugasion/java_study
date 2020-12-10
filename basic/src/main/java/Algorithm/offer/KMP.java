package Algorithm.offer;

/**
 * @author Lucas
 * @date 2019-06-19 21:59
 */
public class KMP {
    public static void main(String[] args) {
        int[] source = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] target = {3, 4, 6};
        System.out.println(find(source, target));
    }

    // 暴力搜索 查找source种target首次出现的位置
    static int find(int[] source, int[] target){
        int s = source.length;
        int t = target.length;
        int i = 0;
        int j = 0;
        while (i+j < s && j < t){
            if (source[i+j] == target[j]){
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
