package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @auther Lucas
 * @date 2019/1/10 10:14
 */
public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        function1();
    }
    static class person implements Serializable {
        private transient String name;
        int age;
        // 自定义序列号
        static final long serialVersionUID = 42L;

        public person() {
        }

        person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        static void run(){
            System.out.println("static run");
        }

        static {
            System.out.println("静态块");
        }
        {
            System.out.println("构造块");
        }
    }
    /**
     * ObjectOutputStream(OutputStream out)
     * void writeObject(Object obj)
     */
    public static void function1() throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\Tang\\java_exercise\\java_study\\main\\IO\\file\\person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        person p1 = new person("lucas",24);
        oos.writeObject(p1);
        oos.close();
    }

}
