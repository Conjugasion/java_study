package innerClass;

/**
 * @author Lucas
 * @date 2019/6/20 17:24
 */
public class InheritInner extends WithInner.Inner {
    // ! InheritInner() {} // Won't compile unless static
    InheritInner(WithInner wi) {
        wi.super();
        System.out.println("this is a constructor in InheritInner");
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}
