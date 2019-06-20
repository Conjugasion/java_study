package innerClass;

/**
 * @auther Lucas
 * @date 2018/12/29 9:47
 */
public class test {
    public static void main(String[] args) {
        Outer1.Inner inner1 = new Outer1().new Inner();
        inner1.show();

        Outer2.Inner inner2 = new Outer2().new Inner();
        inner2.show();

        new Outer3().out();

        // 使用匿名内部类 接口
        new smoking(){
            @Override
            public void smoke() {
                System.out.println("smoking");
            }
        }.smoke();

        // 使用匿名内部类 抽象类
        new swim(){

            @Override
            public void frogSwim() {
                System.out.println("frogSwim");
            }
        }.frogSwim();

        System.out.println(1%50);

        swim s = new swim(){
            @Override
            public void frogSwim() {
                System.out.println("frogSwim");
            }
        };
        s.frogSwim();

        BigEgg.Yolk yolk = new BigEgg().new Yolk();
    }
}
