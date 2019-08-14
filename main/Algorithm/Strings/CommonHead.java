package Algorithm.Strings;

/**
 * @author Lucas
 * @date 2019-08-14 20:21
 * 找到一组字符串的公共开头
 * [string, strqwe, sting]
 * st
 */
public class CommonHead {
    public static void main(String[] args) {
        String[] str = {"string", "strqwe", "sting"};

        String result = "";
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < str.length; i++) {
            String s1 = str[i];
            for (int j = i+1; j < str.length; j++) {
                String s2 = str[j];
                int curLength = 0;
                String curStr = "";
                for (int k = 0, l = 0; k < s1.length() && l < s2.length(); k++, l++) {
                    if (s1.charAt(k)==s2.charAt(l)) {
                        curLength++;
                        curStr += s1.charAt(k);
                    }else break;
                }
                if (curLength < minLength) {
                    minLength = curLength;
                    result = curStr;
                }
            }
        }
        System.out.println("公共前缀是：" + result);

    }
}
