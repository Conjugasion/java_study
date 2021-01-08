package InnerClass.staticInner;

/**
 * @author Lucas
 * @date 2019/5/21 14:05
 */
public class Test {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Parent.Inner1 i1 = parent.new Inner1();
        i1.print();

        Parent.Inner2 i2 = new Parent.Inner2();
        i2.print();
    }
}