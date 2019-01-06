package ExceptionDemo.user_defined;

/**
 * @auther Lucas
 * @date 2019/1/6 16:51
 */
public class myException extends RuntimeException {
    public myException() { }

    public myException(String s){
        super(s);
    }
}
