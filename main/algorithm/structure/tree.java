package algorithm.structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Lucas
 * @date 2019-05-26 18:39
 * 二叉树
 */
public class tree {
    private tree left;
    private tree right;
    private int value;

    public tree(tree left, tree right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public tree(){

    }

    
    // 建树 [1, 3, 2, 5, 4, 6]
    public void init(int[] array){
        if (array.length == 0){
            System.out.println("can't null");
        }
        tree t = this
        tree leftTemp = t;
        tree rightTemp = t;
        for (int i = 0; i < array.length; i++) {

            if (2*i+2 < array.length){
                leftTemp.left = new tree(null, null, array[2*i+1]);
                leftTemp = leftTemp.left;
                rightTemp.right = new tree(null, null, array[2*i+2]);
                rightTemp = rightTemp.right;
            }
            else if (2*i+1 < array.length){
                leftTemp.left = new tree(null, null, array[2*i+1]);
                leftTemp = leftTemp.left;
            }
        }
    }

    public static void main(String[] args) {
        tree t = new tree();
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        t.init(array);
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(0);
//        list.add(4);
//        Collections.sort(list);
//        System.out.println(list);
//        System.out.println(new Integer(1).compareTo(new Integer(2)));
//        System.out.println(new Integer(1).compareTo(new Integer(1)));
//        System.out.println(Integer.compare(1, 0));
//        list.sort((Integer x,Integer y) -> x.compareTo(y));
//        System.out.println(list);

    }
}
