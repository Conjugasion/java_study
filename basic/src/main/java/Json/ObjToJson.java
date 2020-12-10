package Json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;

/**
 * @author tangdongfan
 * @date 2020/5/8 14:25
 */
public class ObjToJson {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("");
        s.setAge(null);
        String str = JSONObject.toJSONString(s, SerializerFeature.WriteNullNumberAsZero);
        byte[] bytes = JSON.toJSONBytes(s);
        String s1 = new String(bytes);
        System.out.println(str);
        System.out.println(s1);
        System.out.println("===================");
        s = new Student();
        s.setName("Lucas");
        s.setAge(26);
        ArrayList<String> hobby = new ArrayList<>();
        hobby.add("swim");
        hobby.add("run");
        s.setHobby(hobby);
        System.out.println(JSONObject.toJSONString(s));
    }
}
