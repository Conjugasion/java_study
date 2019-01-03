package animal;

/**
 * @auther Lucas
 * @date 2019/1/2 15:44
 */
public class test {
    public static void main(String[] args) {
        controlAnimal(new cow());
        controlAnimalCall(new cowCall());
    }

    // 抽象类当做参数
    public static void controlAnimal(animal a){
        a.call();
    }

    // 接口当做参数
    public static void controlAnimalCall(call c){
        c.call();
    }
}
