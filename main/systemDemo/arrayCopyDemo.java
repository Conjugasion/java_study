package systemDemo;

/**
 * @auther Lucas
 * @date 2019/1/3 21:23
 */
public class arrayCopyDemo {
    public static void main(String[] args) {
        int[] src = {11,22,33,44,55,66,77,88,99};
        int[] dest = {1,2,3,4,5};
        int[] dest1 = new int[5];

        //  替换原数组
        System.arraycopy(src,1,dest,1,4);
        for (int i : dest) {
            System.out.println(i);
        }
    }
}
