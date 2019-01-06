package ExceptionDemo;

/**
 * @auther Lucas
 * @date 2019/1/5 10:53
 */
public class ErrorDemo {
    public static void main(String[] args) throws Exception {
        // 1024字节*1024 = 1MB
        // 100MB
        int[] arr = new int[1024*1024*100];
        throw new Exception("Exception");
    }
}
