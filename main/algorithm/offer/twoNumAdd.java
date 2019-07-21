package algorithm.offer;

/**
 * @author Lucas
 * @date 2019-07-20 13:17
 * 两数相加，不使用加减符号
 * 进位carry=(a&b)<<1
 * 相加不考虑进位sum=a^b
 */
public class twoNumAdd {
    public static void main(String[] args) {
        int num1 = 13;
        int num2 = 11;
        while (num2!=0){
            int sum = num1^num2;
            int carry = (num1&num2)<<1;
            num1 = sum;
            num2 = carry;
        }
        System.out.println(num1);
    }
}
