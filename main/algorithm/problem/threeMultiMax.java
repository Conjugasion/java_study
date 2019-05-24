package algorithm.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther Lucas
 * @date 2019/2/22 17:24
 */
public class threeMultiMax {
    public static void main (String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);
        Integer number = Integer.valueOf(bf.readLine());
        String[] nums = bf.readLine().split(" ");

        Long[] a = new Long[nums.length];
        for (int i=0; i < nums.length; i++){
            a[i] = Long.valueOf(nums[i]);
        }

        List<Long> b  = new ArrayList<>();
        List<Long> c  = new ArrayList<>();
        List<Long> d  = new ArrayList<>();
        for (Long i : a){
            if(i>0){
                b.add(i);
            }
            else if(i<0){
                c.add(i);
            }
            else{
                d.add(i);
            }
        }

        if(b.size() >= 3){
            if (c.size() >= 2){
                b.sort((i1,i2) -> i2.compareTo(i1));
                c.sort((i1,i2) -> i2.compareTo(i1));
                Long bResult = b.get(0) * b.get(1) * b.get(2);
                Long cResult = c.get(c.size()-1) * c.get(c.size()-2) * b.get(0);
                Long result = (bResult > cResult) ? bResult:cResult;
                System.out.println(result);
            }
            else {
                b.sort((i1,i2) -> i2.compareTo(i1));
                Long bResult = b.get(0) * b.get(1) * b.get(2);
                System.out.println(bResult);
            }
        }
        else if (b.size() == 2){
            if (c.size() >=2){
                b.sort((i1,i2) -> i2.compareTo(i1));
                c.sort((i1,i2) -> i2.compareTo(i1));
                Long result = c.get(c.size()-1) * c.get(c.size()-2) * b.get(0);
                System.out.println(result);
            }
            else if (c.size() == 1){
                if (d.size() != 0){
                    System.out.println(0);
                }
                else {
                    Long result = c.get(0) * b.get(0) * b.get(1);
                    System.out.println(result);
                }
            }
            else {
                System.out.println(0);
            }
        }
        else if (b.size() == 1){
            if (c.size() >=2 ){
                c.sort((i1,i2) -> i2.compareTo(i1));
                Long result = c.get(c.size()-1) * c.get(c.size()-2) * b.get(0);
                System.out.println(result);
            }
            else {
                System.out.println(0);
            }
        }
    }
}
