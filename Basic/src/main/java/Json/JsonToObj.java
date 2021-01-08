package Json;

import com.alibaba.fastjson.JSON;

/**
 * @author tangdongfan
 * @date 2020/8/24 14:45
 */
public class JsonToObj {
    public static void main(String[] args) {
        String str1 = "{\"name\":\"Lucas\",\"age\":\"26\",\"address\":\"shanghai\"}";
        Student stu1 = JSON.parseObject(str1, Student.class);
        System.out.println(stu1);
        String str2 = "{\"name\":\"Lucas\"}";
        Student stu2 = JSON.parseObject(str2, Student.class);
        System.out.println(stu2);
    }
}
