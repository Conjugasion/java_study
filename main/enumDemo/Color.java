package enumDemo;

/**
 * @author Lucas
 * @date 2019/3/26 10:21
 */
public enum Color {
    RED,BLUE,YELLOW;
    private Color(){
        System.out.println("enum类的私有构造器");
    }

    public static void main(String[] args) {
        System.out.println(Color.BLUE);
    }
}
