package innerClass;

/**
 * @auther Lucas
 * @date 2018/12/29 14:34
 */
public interface smoking {
    public abstract void smoke();
    default void achieve(){
        System.out.println("接口的实现方法");
    }
}
