package algorithm.offer;

/**
 * @author Lucas
 * @date 2019-06-23 14:13
 * AAABBCCD
 * A3B2C2D1
 */
public class AABBC {
    public static void main(String[] args) {
        String str = "AAABBCCD";
        System.out.println(transfer(str));
    }

    static String transfer(String str){
        char[] chars = str.toCharArray();
        char current = chars[0];
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (current == chars[i]){
                count += 1;
            }
            else {
                result.append(current);
                result.append(count);
                current = chars[i];
                count = 1;
            }
            if (i==chars.length-1){
                result.append(current);
                result.append(count);
            }

        }
        return result.toString();
    }
}
