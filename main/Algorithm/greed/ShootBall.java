package Algorithm.greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Lucas
 * @date 2019-08-03 16:45
 * 已知在水平面上有一定数量的气球，在x轴方向安排弓箭手向y轴方向射箭，攻坚可以飞无限远
 * 给定气球宽度xstart<=x<=xend，问至少需要多少弓箭手才能将全部气球打爆
 * 比如气球(1,6),(2,8),(7,12),(10,16),至少需要两名弓箭手(2,6),(7,10)
 */
public class ShootBall {
    public static void main(String[] args) {
        ArrayList<int[]> points = new ArrayList<>();
        points.add(new int[]{2,8});
        points.add(new int[]{1,6});
        points.add(new int[]{10,16});
        points.add(new int[]{7,12});
        points.add(new int[]{3,5});
        System.out.println("最少需要" + findMinArrows(points) + "名弓箭手");
        for (int[] i:points) {
            System.out.println(Arrays.toString(i));
        }
    }

    // 维护一个射箭区间，当该射击区间不能射爆下一个气球的时候，增加一名新的射击手，重新维护一个新的射击区间
    static int findMinArrows(ArrayList<int[]> points){
        if (points.size()==0) return 0;
        Collections.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int shootMan = 1;     // 初始化弓箭手数量
        int shootBegin = points.get(0)[0];    // 初始化左侧射击区间
        int shootEnd = points.get(0)[1];      // 初始化右侧射击区间
        for (int i = 1; i < points.size(); i++) {
            /*  因为points已经根据左端点进行了排序，所以只有以下几种情况
            2.     ----          -----    -----         --------           ----    ----
            1.  ----------    ------         -----        ----        ----              ----
                   可能         可能        不可能         不可能          可能          不可能
            当xxx条件下更新射击区间
            */
            if (points.get(i)[0] <= shootEnd){
                shootBegin = points.get(i)[0];
                if (points.get(i)[1] <= shootEnd){
                    shootEnd = points.get(i)[1];
                }
            }else {  // 需要增加人手了
                shootMan++;
                shootBegin = points.get(i)[0];
                shootEnd = points.get(i)[1];
            }
        }
        return shootMan;
    }
}
