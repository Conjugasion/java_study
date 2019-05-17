package volatileDemo;

/**
 * @author Lucas
 * @date 2019/5/17 9:08
 * volatile 关键字
 */
public class volatileFeature {
    private volatile long i = 0L;

    public void set(long i) {
        this.i = i;
    }

    public void increase(){
        i++;
    }

    public long get(){
        return i;
    }


}
