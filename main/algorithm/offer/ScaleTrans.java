package algorithm.offer;

/**
 * @author Lucas
 * @date 2019/7/19 14:05
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class ScaleTrans {
    public static void main(String[] args) {
        int i = 5;
        String i2 = Integer.toBinaryString(i);
        System.out.println(i2);
        int j = 6;
        String j2 = Integer.toBinaryString(j);
        System.out.println(j2);
        int s = 30;
        String s2 = Integer.toBinaryString(s);
        System.out.println(s2);
    }

}
