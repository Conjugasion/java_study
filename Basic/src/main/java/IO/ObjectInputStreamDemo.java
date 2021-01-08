package IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @auther Lucas
 * @date 2019/1/10 10:23
 */
public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        function1();
    }
    /**
     * ObjectInputStream(InputStream in)
     * Object readObject()
     */
    public static void function1() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("D:\\Tang\\java_exercise\\java_study\\main\\IO\\file\\person.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ObjectOutputStreamDemo.person p1 = (ObjectOutputStreamDemo.person)ois.readObject();
        System.out.println(p1);
        p1.run();
        ois.close();
    }
}
