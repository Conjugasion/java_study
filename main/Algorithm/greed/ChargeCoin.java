package Algorithm.greed;

/**
 * @author Lucas
 * @date 2019-08-02 14:55
 * 有1，5，10，20，100，200面值的货币，现使用这些钞票支付x元，最少要使用多少张
 * 为什么贪心法能找到最优解，因为任意面值都是比其小的面值的整数倍
 * 若有7块钱面值的货币，则不能用贪心法
 */
public class ChargeCoin {
    public static void main(String[] args) {
        int[] money = {1,5,10,20,100,200};
        int num = 628;    // 要支付的钱
        int count = 0;    // 使用钞票的数量
        for (int i = money.length-1; i >= 0; i--) {
            int use = num/money[i];
            count += use;
            num = num%money[i];
            if (use!=0) System.out.println("面值" + money[i] + "的钞票使用了" + use + "张");
            if (num==0) break;
        }
        System.out.println("最少要使用" + count + "张钞票");
    }
}
