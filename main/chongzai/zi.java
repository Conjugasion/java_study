package chongzai;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/**
 * @auther Lucas
 * @date 2019/2/27 19:38
 */
public class zi extends fu{
    //
    public void run(int i){

    }

    // 重写
    public void run() throws IOException {
        System.out.println("zi run");
        try {
            throw new Exception("主动抛出Exception");
        }catch (Exception e){
            System.out.println("catch Exception");
        }
    }

    public static void main(String[] args) throws IOException {
        new zi().run();
    }
}
