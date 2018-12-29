package superDemo;

/**
 * @auther Lucas
 * @date 2018/12/28 14:42
 */
public class student extends person {
    {
        System.out.println("student no static");
    }
    static {
        System.out.println("student static");
    }
    public student(String name){
        super("lucas");
        System.out.println("student name");
    }

    public student(int age){
        super(25);
        System.out.println("student age");
    }

    public student(){
        this(24);
    }


    public static void main(String[] args) {
        student s1 = new student("lucas");      // 错咯 person static, person no static, person name, student static, student no static, student name
                                                       // 正确 person static, student static, person no static, person name, student no static, student name
        System.out.println("*************");
        student s2 = new student("lucas");      // person no static, person name, student no static, student name

        System.out.println("**************");
        student s3 = new student("lucas");      // person no static, person name, student no static, student name
    }
}
