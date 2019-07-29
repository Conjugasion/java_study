package algorithm.offer;

import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-07-09 22:01
 *输入数组是不是后序遍历
 */
public class ArrayIsPost {
    public static void main(String[] args) {
        int[] post = new int[]{3,2,4,6,8,7,5};
        System.out.println(VerifySquenceOfBST(post));
    }
    public static boolean VerifySquenceOfBST(int [] sequence) {
        // 3 2 4 6 8 7 5
        int[] old = Arrays.copyOfRange(sequence,0,sequence.length);  // 后序遍历
        Arrays.sort(sequence);    // 中序遍历 2 3 4 5 6 7 8
        return affirm(old,0,old.length-1,sequence,0,sequence.length-1);
    }

    static boolean affirm(int[] old, int s1, int e1, int[] seq, int s2, int e2){
        if (s1 <= e1 && s2 <= e2){
            int i;
            boolean flag = false;
            for(i=s2;i<=e2;i++){
                if (seq[i]==old[e1]){
                    flag = true;
                    break;
                }
            }
            if(flag && affirm(old,s1,i-1,seq,s2,i-1) && affirm(old,i+1,e1-1,seq,i+1,e2)){
                return true;
            }
            else return false;
        }
        return true;
    }
}
