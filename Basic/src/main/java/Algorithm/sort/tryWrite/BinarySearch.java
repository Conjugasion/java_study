package Algorithm.sort.tryWrite;

/**
 * @author Lucas
 * @date 2019-06-23 17:52
 */
public class BinarySearch {
    public static void main(String[] args) {

        int[] array = {1, 3, 5, 5, 5, 7, 9, 11};
        System.out.println("递归实现：" + search(array, 0, array.length-1, 5));
        System.out.println("非递归实现：" + searchV(array, 0, array.length-1, 5));
        System.out.println("找最后出现的索引：" + getLastIndex(array, 0, array.length-1, 5));

    }

    // 递归实现
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
    // 非递归实现
    static int searchV(int[] array, int start, int end, int target){
        if (start <= end){
            int mid = (start+end)>>>1;
            while (start<=end){
                if (array[mid] < target){
                    start = mid + 1;
                }
                else if (array[mid] > target){
                    end = mid - 1;
                }
                else {
                    return mid;
                }
            }
        }
        return -1;
    }

    // 找最后出现的target索引,有点问题。。。
    static int getLastIndex(int[] array, int start, int end, int target){
        if (start <= end){
            int mid = (start+end)/2;
            while (start<=end){
                if (array[mid] < target){
                    start = mid + 1;
                }
                else if (array[mid] > target){
                    end = mid - 1;
                }
                else if(mid+1 < array.length && array[mid+1] == target){
                    start = mid+1;
                }
                else {
                    return mid;
                }
            }
        }
        return -1;
    }
}
