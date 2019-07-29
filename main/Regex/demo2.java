package Regex;

/**
 * @auther Lucas
 * @date 2019/1/3 16:15
 */
public class demo2 {
    public static void main(String[] args) {
        String hello = "Hello13345World12453";
        String hello1 = hello.replaceAll("\\d+"," ");
        System.out.println(hello1);
    }
}
