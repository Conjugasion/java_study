package Algorithm.offer;

/**
 * @author tangdongfan
 * @date 2020/7/13 15:35
 * 约瑟环
 * 将n个孩子从0到n-1编上号，按序号围坐成一个圈，从1数到m，数到m的孩子离开圈子，然后从下一个孩子开始，再从1开始数，如此不断地数下去，只到只剩下最后一个孩子，问剩下的孩子是几号？
 */
public class JosephRing {
    public static void main(String[] args) {
        int n = 3;
        int m = 2;
        function(n,m);

    }

    static void function(int n, int m) {
        int[] children = new int[n];
        for (int i = 0;i<n;i++) {
            children[i] = i;
        }
        int count = n;
        int index = 0;
        while (count!=1) {
            int i = 1;
            while (i <= m) {
                if (children[index % n] != -1) {
                    if (i == m) {
                        count--;
                        children[index % n] = -1;
                        if (count == 1) {
                            break;
                        }
                    }
                    i++;
                }
                index++;
            }
        }
        for (int child : children) {
            if (child!=-1) {
                System.out.println(child);
            }
        }
    }
}
