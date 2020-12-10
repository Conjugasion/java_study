package Algorithm.offer;

/**
 * @author Lucas
 * @date 2019-05-29 21:22
 * 旋转数组
 */
public class XuanZhuanArray {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0){
            return 0;
        }
        else {
            for(int i=0; i < array.length; i++){
                if(i==array.length-1){
                    return array[0];
                }
                else if(array[i]>array[i+1] && array[0] < array[i+1]){
                    return array[0];
                }
                else if (array[i]>array[i+1] && array[0] >= array[i+1]){
                    return array[i+1];
                }
            }
        }
        return 0;
    }
}
