package algorithm.sort.tryWrite;

/**
 * @author Lucas
 * @date 2019-06-23 17:52
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11};
        System.out.println(search(array, 0, array.length-1, 5));
    }

    static int search(int[] array, int start, int end, int target){
        if (start <= end){
            int mid = (start + end)/2;
            if (array[mid] > target){
                return search(array, start, mid-1, target);
            }
            else if (array[mid] < target){
                return search(array, mid+1, end, target);
            }
            else return mid;
        }
        return -1;
    }
}
