package volatileDemo;

/**
 * @author Lucas
 * @date 2019/5/17 22:23
 */
public class OutOfOrder {
    int i = 0;
    boolean flag = false;

    public void write(){
        i = 1;
        flag = true;
    }

    public void read(){
        if(flag){
            System.out.println(i*i);
        }else {
            System.out.println(i*i);
        }
    }
}
