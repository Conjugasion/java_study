package TryFinally;

/**
 * @auther Lucas
 * @date 2019/3/3 21:33
 */
public class tryFinally {
    static int arr[] = new int[3];
    static char[] ch = new char[3];//默认空格
    static int [] Int = new int[3];//默认0
    static String[] strings = new String[3];//默认null
    static float[] floats = new float[3];//默认0.0f
    static class A {
        protected int value;
        public A (int v) {
            setValue(v);
        }
        public void setValue(int value) {
            this.value= value;
        }
        public int getValue() {
            try {
                value ++;
                return value;
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
        }
    }
    static class B extends A {
        public B () {
            super(5);
            setValue(getValue()- 3);
        }
        @Override
        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }

    public static void main(String[] args) {
        System.out.println(new B().getValue());
        System.out.println(arr[2]);
        System.out.println(ch[2]);
        System.out.println(Int[2]);
        System.out.println(strings[2]);
        System.out.println(floats[2]);

        System.out.println(-1 << 2);
        System.out.println(-4 >> 1);

        System.out.println(tryFinally.class.getSimpleName());
    }
}
