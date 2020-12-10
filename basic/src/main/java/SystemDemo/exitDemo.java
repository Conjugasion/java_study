package SystemDemo;

/**
 * @auther Lucas
 * @date 2019/1/3 21:03
 * 退出虚拟机，所有程序全部停止
 * exit(status)，status非零表示异常终止，0表示正常终止
 */
public class exitDemo {
    public static void main(String[] args) {
        while (true){
            System.out.println("hello world");
            System.exit(0);
        }
    }
}
