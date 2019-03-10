package ThreadDemo.threadLocalDemo;

/**
 * @auther Lucas
 * @date 2019/2/28 21:39
 */
public class demo1 {
    ThreadLocal<Integer> t = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            System.out.println("调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！");
            return null;
        }
    };



}
