package File;

import java.io.File;
import java.io.IOException;

/**
 * @auther Lucas
 * @date 2019/1/6 21:27
 */
public class fileCreateAndDelete {
    public static void main(String[] args) throws IOException {
        function4();
    }

    /**
     * 创建文件
     * @throws IOException
     */
    public static void function1() throws IOException {
        File file = new File("D:\\Tang\\java_exercise\\java_study\\main\\File\\file\\a.txt");
        boolean b = file.createNewFile();
        System.out.println(b);
    }

    /**
     * 创建文件夹
     * @throws IOException
     */
    public static void function2() throws IOException {
        File file = new File("D:\\Tang\\java_exercise\\java_study\\main\\File\\file\\dirInner");
        boolean b = file.mkdir();
        System.out.println(b);
    }

    /**
     * 创建多个文件夹
     * @throws IOException
     */
    public static void function3() throws IOException {
        File file = new File("D:\\Tang\\java_exercise\\java_study\\main\\File\\file\\manyDir\\dir1\\dir2");
        boolean b = file.mkdirs();
        System.out.println(b);
    }

    /**
     * 删除文件/文件夹
     */
    public static void function4(){
        File file = new File("D:\\Tang\\java_exercise\\java_study\\main\\File\\file\\dirInner");
        boolean b = file.delete();
        System.out.println(b);
    }
}
