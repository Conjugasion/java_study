package innerClass;

/**
 * @author Lucas
 * @date 2019/6/20 16:50
 */
public class BigEgg extends Egg {
    public class Yolk {
        public Yolk() {
            System.out.println("BigEgg.Yolk()");
        }
    }

    public static void main(String[] args) {
        new BigEgg();
    }
}
