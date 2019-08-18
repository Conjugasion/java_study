package Algorithm.offer;

import java.util.*;


/**
 * @author Lucas
 * @date 2019-07-14 16:57
 * 逆序对
 */
public class NiXuDui {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int[] array = new int[10];
            for (int j = 0; j < 10; j++) {
                array[j] = r.nextInt(20);
            }
            System.out.println("array = " + Arrays.toString(array));
            System.out.println("InversePairs1方法：" + InversePairs1(array));
            System.out.println("InversePairs2方法：" + InversePairs2(array));
            System.out.println("----------------");
        }
    }

    // 方法1
    public static int InversePairs1(int[] array) {
        int[] clone = array.clone();
        //return sum(array)%1000000007;
        int[] midResult = new int[array.length];
        for(int i=0;i<array.length;i++){
            midResult[i] = -1;
        }
        midResult[array.length-1] = 0;
        return sum(array, 0, array.length-1, midResult)%1000000007;
    }

    static int sum(int[] array, int start, int end, int[] midResult){
        if(array.length == 0 || array.length == 1){
            return 0;
        }
        if(midResult[start]!=-1){
            return midResult[start];
        }
        if(start<end){
            int partNum = sum(array, start+1, end, midResult);
            int num = array[start];
            int count = 0;
            for(int i=start+1;i<=end;i++){
                if(num > array[i]){
                    count++;
                }
            }
            midResult[start] = partNum + count;
            return midResult[start];
        }
        else return 0;
    }



    // 方法2 归并思想
    static int InversePairs2(int[] array) {
        if(array==null || array.length<=0){
            return 0;
        }
        int pairsNum=mergeSort(array,0,array.length-1);
        return pairsNum;
    }

    static int mergeSort(int[] array,int left,int right){
        if(left==right){
            return 0;
        }
        int mid=(left+right)/2;
        int leftNum=mergeSort(array,left,mid);
        int rightNum=mergeSort(array,mid+1,right);
        return (Sort(array,left,mid,right)+leftNum+rightNum)%1000000007;
    }

    static int Sort(int[] array,int left,int middle,int right){
        int current1=middle;
        int current2=right;
        int current3=right-left;
        int temp[]=new int[right-left+1];
        int pairsnum=0;
        while(current1>=left && current2>=middle+1){
            if(array[current1]>array[current2]){
                temp[current3--]=array[current1--];
                pairsnum+=(current2-middle);     //这个地方是current2-middle！！！！
                if(pairsnum>1000000007)//数值过大求余
                {
                    pairsnum%=1000000007;
                }
            }else{
                temp[current3--]=array[current2--];
            }
        }
        while(current1>=left){
            temp[current3--]=array[current1--];
        }
        while(current2>=middle+1){
            temp[current3--]=array[current2--];
        }
        //将临时数组赋值给原数组
        int i=0;
        while(left<=right){
            array[left++]=temp[i++];
        }
        return pairsnum;
    }
}
