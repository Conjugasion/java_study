package innerClass.staticInner;

/**
 * @author Lucas
 * @date 2019/5/21 14:05
 */
class Parent {
    class Inner1 {
        public void print() {
            System.out.println("xxx");
        }
    }

    static class Inner2 {
        public void print() {
            System.out.println("xxx");
        }
    }
}