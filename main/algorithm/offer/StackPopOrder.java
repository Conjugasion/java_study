package algorithm.offer;

import java.util.ArrayList;

/**
 * @author Lucas
 * @date 2019-07-03 22:17
 */
public class StackPopOrder {
    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        System.out.println(IsPopOrder(pushA,popA));
    }

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        ArrayList<Integer> stack = new ArrayList<>();
        int Alength = 0;
        for(int i=0;i<popA.length;i++){
            if (!stack.contains(popA[i])){
                for(int j=Alength;j<pushA.length;j++){
                    stack.add(pushA[j]);
                    if (pushA[j] == popA[i]){
                        Alength = j+1;
                        break;
                    }
                }
            }
            if (popA[i]==stack.remove(stack.size()-1)){
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
