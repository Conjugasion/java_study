package chongzai;

/**
 * @auther Lucas
 * @date 2019/2/28 20:06
 */
public class ext extends abstr {
    public static void main(String[] args) {
        // new abstr();
        System.out.println(new ext().getClass().getName());
        int[] a = new int[10];
        a[0] = 123;
        String foo1 = args[1];
        String foo2 = args[2];
        String foo3 = args[3];

        
    }

    @Override
    public void swim() {

    }
}
