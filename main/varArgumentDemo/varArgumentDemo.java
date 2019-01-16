package varArgumentDemo;

/**
 * @auther Lucas
 * @date 2019/1/4 21:01
 * 可变参数本质是数组
 * 一个方法只能有一个可变参数
 */
public class varArgumentDemo {
    public static void main(String[] args) {
        System.out.println(getSum(1,2,3, 4, 5));
    }

    public static int getSum(int a, int b,int...num){
        int sum = 0;
        for (int i : num) {
            sum = sum + i;
        }
        return sum;
    }
}
