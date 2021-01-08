package FinalDemo.finalMember;

/**
 * @auther Lucas
 * @date 2018/12/28 15:43
 */
public class person {
    // final变量初始化方式1
    {
        this.age = 10;
    }
    final int age ;

    // final变量初始化方式2
    final String name;

    public person(String name){
        this.name = name;
    }


}
