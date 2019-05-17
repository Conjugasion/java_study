package finalDemo.finalReferEscape;

/**
 * @author Lucas
 * @date 2019/5/17 14:14
 */
public class finalReferEscape {
    final int i;
    static finalReferEscape obj;

    public finalReferEscape(){
        i = 1;
        obj = this;
    }

    public static void writer(){
        new finalReferEscape();
    }

    public static void reader(){
        if(obj != null){
            int temp = obj.i;
            System.out.println(temp);
        }
    }

}
