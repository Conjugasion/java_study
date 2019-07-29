package algorithm.offer;

/**
 * @author Lucas
 * @date 2019-05-29 22:07
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级、3级、4级... 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 * f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(2) + f(1) + f(0)
 */
public class QingWaTiao2 {
    public static void main(String[] args) {
        int[] midResult = new int[10000];
        System.out.println(JumpFloor(5, midResult));
    }

    /*
    递推
     */
    static int JumpFloor(int target, int[] midResult){
        midResult[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= i; j++) {
                midResult[i] += midResult[i-j];
            }
        }
        return midResult[target];
    }
}
