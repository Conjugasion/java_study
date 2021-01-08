package ExceptionDemo;

import java.io.IOException;

/**
 * @auther Lucas
 * @date 2019/1/5 11:28
 * finally
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        // int[] arr = null;
        int[] arr = new int[0];
        try{
            int i = getArray(arr);
            System.out.println(i);
            return;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException");
            return;
        }catch (NullPointerException e){
            System.out.println("NullPointerException");
        }finally {
            System.out.println("finally");
        }
        System.out.println("Game Over");

    }

    public static int getArray(int[] arr){
        return arr[arr.length-1] + 1;
    }
}
