package algorithm.offer;

/**
 * @author Lucas
 * @date 2019-05-29 22:07
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 * f(n) = f(n-1) + f(n-2)
 */
public class problem8 {
    public static void main(String[] args) {
        System.out.println(JumpFloor(1));

        int[] midResult = new int[5];
        for (int i = 0; i < 5; i++) {
            midResult[i] = -1;
        }
        System.out.println(JumpFloor(1, midResult));
    }

    /*
    递归版
     */
    static int JumpFloor(int target) {
        if (target==0){
            return 0;
        }
        else if (target==1){
            return 1;
        }
        else if (target==2){
            return 2;
        }
        else return JumpFloor(target-1) + JumpFloor(target-2);
    }

    /*
    记忆型递归
     */
    static int JumpFloor(int target, int[] midResult){
        if (target==0){
            return midResult[0] = 0;
        }
        else if (target==1){
            return midResult[1] = 1;
        }
        else if (target==2){
            return midResult[2] = 2;
        }
        if (midResult[target-1] == -1){
            midResult[target-1] = JumpFloor(target-1, midResult);
        }
        if (midResult[target-2] == -1){
            midResult[target-2] = JumpFloor(target-2, midResult);
        }
        return midResult[target-1] + midResult[target-2];
    }
}
