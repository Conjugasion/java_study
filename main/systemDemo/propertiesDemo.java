package systemDemo;

import java.util.Scanner;

/**
 * @auther Lucas
 * @date 2019/1/3 21:22
 */
public class propertiesDemo {
    public static void main(String[] args) {
        System.out.println(System.getProperties());
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        int d = sc.nextInt();
        System.out.println("a: " + a + ",b: " + b + ",c: " + c);
        System.out.println("d: " + d);
    }
}
