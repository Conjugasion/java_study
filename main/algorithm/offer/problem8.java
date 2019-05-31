package algorithm.offer;

/**
 * @author Lucas
 * @date 2019-05-29 22:07
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 * n = 1*x + 2*y
 */
public class problem8 {
    public static int JumpFloor(int target) {
        if (target == 0){
            return 0;
        }
        int count = 1;
        int x = 0;
        while (true){
            x++;
            if((target - x)%2==0){
                count++;
            }
            if (target - x == 0){
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(2));
    }
}
