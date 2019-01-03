package permission2;

import permission1.father;

/**
 * @auther Lucas
 * @date 2018/12/29 16:19
 */
public class son extends father {
    protected int a = 100;

    protected son() {
    }

    public void sonMethod(){
        // 很坑
        fatherMethon();

    }

    public static void main(String[] args) {
        new son();
    }
}
