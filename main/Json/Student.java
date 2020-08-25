package Json;

import java.util.List;

/**
 * @author tangdongfan
 * @date 2020/5/8 14:25
 */
public class Student {
    private String name;
    private Integer age;
    private List<String> hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + hobby +
                '}';
    }
}
