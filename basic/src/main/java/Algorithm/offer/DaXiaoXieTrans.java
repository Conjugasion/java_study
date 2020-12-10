package Algorithm.offer;

/**
 * @author Lucas
 * @date 2019-07-17 21:38
 * 大小写转换
 */
public class DaXiaoXieTrans {
    public static void main(String[] args) {
        String str = "aBcDeFg";
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (65<=chars[i]&&chars[i]<=90){
                sb.append((char)(chars[i]+32));
            }
            else if (97<=chars[i]&&chars[i]<=122){
                sb.append((char)(chars[i]-32));
            }
        }
        System.out.println(sb);
    }
}
