package ExceptionDemo.abstractException;


import javax.swing.text.ChangedCharSetException;
import java.io.IOException;

/**
 * @auther Lucas
 * @date 2019/1/6 15:49
 */
public class extendExcept extends abstractExcept implements interfaceExcept{
    @Override
    public void function1() throws IOException {
        System.out.println("实现抽象方法");
    }

    @Override
    public void fundtion2() {
        System.out.println("实现抽象方法");
    }

    @Override
    public void function3() throws ChangedCharSetException {

    }

    @Override
    public void function4(){

    }
}
