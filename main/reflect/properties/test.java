package reflect.properties;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @auther Lucas
 * @date 2019/1/16 10:22
 */
public class test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Tang\\java_exercise\\java_study\\main\\reflect\\properties\\config.properties"));
        Properties properties = new Properties();

        properties.load(br);
        br.close();
        String methodName = properties.getProperty("methodName");
        String className = properties.getProperty("className");

        Class c = Class.forName(className);
        Object obj = c.newInstance();

        Method m = c.getMethod(methodName,null);
        m.invoke(obj, null);

    }
}
