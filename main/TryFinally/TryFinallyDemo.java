package TryFinally;

/**
 * @author Lucas
 * @date 2019/8/8 14:04
 */
public class TryFinallyDemo {
    public static void main(String[] args) {
        System.out.println(mathError(0));
    }

    static int mathError(int i){
        try {
            return 10/i;
        }catch (ArithmeticException e){
            e.printStackTrace();
            return -1;      // try和finally必须要有一个return
        }finally {
            //return -2;   // 以finally为准
        }
    }
}
