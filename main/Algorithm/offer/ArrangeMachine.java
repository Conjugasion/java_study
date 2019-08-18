package Algorithm.offer;

import java.util.*;

/**
 * @author Lucas
 * @date 2019/8/17 16:09
 * 小Q的公司最近接到m个任务, 第i个任务需要xi的时间去完成, 难度等级为yi。
 * 小Q拥有n台机器, 每台机器最长工作时间zi, 机器等级wi。
 * 对于一个任务,它只能交由一台机器来完成, 如果安排给它的机器的最长工作时间小于任务需要的时间, 则不能完成,如果完成这个任务将获得200 * xi + 3 * yi收益。
 *
 * 对于一台机器,它一天只能完成一个任务, 如果它的机器等级小于安排给它的任务难度等级, 则不能完成。
 *
 * 小Q想在今天尽可能的去完成任务, 即完成的任务数量最大。如果有多种安排方案,小Q还想找到收益最大的那个方案。小Q需要你来帮助他计算一下。
 *
 *
 * 输入描述:
 * 输入包括N + M + 1行,
 * 输入的第一行为两个正整数n和m(1 <= n, m <= 100000), 表示机器的数量和任务的数量。
 * 接下来n行,每行两个整数zi和wi(0 < zi < 1000, 0 <= wi <= 100), 表示每台机器的最大工作时间和机器等级。
 * 接下来的m行,每行两个整数xi和yi(0 < xi < 1000, 0 <= yi<= 100), 表示每个任务需要的完成时间和任务的难度等级。
 *
 * 输出描述:
 * 输出两个整数, 分别表示最大能完成的任务数量和获取的收益。
 *
 * 输入例子1:
 * 1 2
 * 100 3
 * 100 2
 * 100 1
 *
 * 输出例子1:
 * 1 20006
 */
public class ArrangeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<int[]> machines = new ArrayList<>();
        ArrayList<int[]> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] machine = {sc.nextInt(), sc.nextInt()};
            machines.add(machine);
        }
        for (int i = 0; i < m; i++) {
            int[] task = {sc.nextInt(), sc.nextInt()};
            tasks.add(task);
        }
        arrange(machines, tasks);
    }

    //
    static void arrange(ArrayList<int[]> machines, ArrayList<int[]> tasks){
        tasks.sort(new Comparator<int[]>() {            // 根据任务的价值，从大到小排序
            @Override
            public int compare(int[] o1, int[] o2) {
                int value1 = 200*o1[0] + 3*o1[1];
                int value2 = 200*o2[0] + 3*o2[1];
                return value2-value1;
            }
        });
        machines.sort(new Comparator<int[]>() {        // 根据机器能产出的最大价值，从小到大排序
            @Override
            public int compare(int[] o1, int[] o2) {
                int value1 = 200*o1[0] + 3*o1[1];
                int value2 = 200*o2[0] + 3*o2[1];
                return value1-value2;
            }
        });

        int count = 0;
        int value = 0;
        for (int[] t:tasks) {
            if (find(machines, t)){
                count++;
                value += 200*t[0] + 3*t[1];
            }
        }
        System.out.print(count);
        System.out.print(" ");
        System.out.print(value);
    }

    // 根据任务的时间和登记选择 最合适的 机器
    static boolean find(ArrayList<int[]> machines, int[] task){
        for (int[] m:machines) {
            if (m[0]>=task[0]&&m[1]>=task[1]){
                machines.remove(m);
                return true;
            }
        }
        return false;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                for(int k=j;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        ArrayList<Integer> sub = new ArrayList<>();
                        sub.add(nums[i]);
                        sub.add(nums[j]);
                        sub.add(nums[k]);
                        result.add(sub);
                    }
                }
            }
        }
        return result;
    }
}
