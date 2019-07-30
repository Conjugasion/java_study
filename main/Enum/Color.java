package Enum;

/**
 * @author Lucas
 * @date 2019/3/26 10:21
 */
public enum Color {
    RED("red"){
        @Override
        String getInfo() {
            return "红";
        }
    },
    BLUE("blue") {
        @Override
        String getInfo() {
            return "蓝";
        }
    },
    YELLOW("yellow") {
        @Override
        String getInfo() {
            return "黄";
        }
    };

    private String desc;//中文描述
    Color(String desc){
        this.desc = desc;
        System.out.println("enum类的私有构造器");
    }    // 会运行三次

    public String getDesc(){
        return desc;
    }

    // 可以定义抽象方法
    abstract String getInfo();

    public static void main(String[] args) {
        for (Color color: Color.values()) {
            System.out.println("name: " + color.name() + " ,desc: " + color.getDesc() + ", info: " + color.getInfo());
        }
    }
}
