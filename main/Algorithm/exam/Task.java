package Algorithm.exam;

import java.util.*;

/**
 * @author Lucas
 * @date 2019-07-28 15:36
 */
public class Task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] p = new int[n];   // 耗时
        int[] task = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
            task[i] = i+1;
        }
        ArrayList<int[]> depend = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] temp = new int[2];
            temp[0] = sc.nextInt();
            temp[1] = sc.nextInt();
            depend.add(temp);
        }
        System.out.println("n: " + n);
        System.out.println("m: " + m);
        System.out.println("p: " + Arrays.toString(p));
        for (int[] i:depend) {
            System.out.println(Arrays.toString(i));
        }
        ArrayList<int[]> result = new ArrayList<>();
        pailie(task, 0, n-1, result);
        ArrayList<int[]> possible = new ArrayList<>(result);
        for (int[] i:depend) {  //约束条件
            int first = i[0];
            int second = i[1];
            for (int[] j :result) {  //全排列结果
                for (int k:j) {    // 检验结果
                    if (k==first){
                       break;
                    }else if (k==second){
                        possible.remove(j);
                        break;
                    }
                }
            }
        }
        System.out.println("possible: ");
        for (int[] i:possible) {
            System.out.println(Arrays.toString(i));
        }

        float minReturnTime = Integer.MAX_VALUE;
        ArrayList<int[]> possible2 = new ArrayList<>();
        for (int[] i:possible) {
            float returnTime = 0.0f;
            float[] curTime = new float[n];
            int x = 0;
            for (int j:i) {      // 第几号任务
                if (x==0) {
                    curTime[x] = p[j-1];
                    x++;
                }else {
                    curTime[x] = p[j-1]+curTime[x-1];
                    x++;
                }
            }
            for (float j:curTime) {
                returnTime += j/6.0;
            }
            if (returnTime<minReturnTime){
                minReturnTime = returnTime;
                possible2.clear();
                possible2.add(i);
            }else if (returnTime==minReturnTime){
                possible2.add(i);
            }
        }

        possible2.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                StringBuilder s1 = new StringBuilder();
                for (int i:o1) {
                    s1.append(i);
                }
                StringBuilder s2 = new StringBuilder();
                for (int i:o2) {
                    s2.append(i);
                }
                return s1.toString().compareTo(s2.toString());
            }
        });
        System.out.println("possible2: ");
        for (int[] i:possible2) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("min: ");
        int[] pdd = possible2.get(0);
        for (int i = 0; i < pdd.length; i++) {
            if (i!=pdd.length-1) System.out.print(pdd[i] + " ");
            else System.out.print(pdd[i]);
        }
    }

    // 带重复数字 递归版
    static void pailie(int[] str, int from, int to, ArrayList<int[]> result) {
        if (from == to) {
            int[] temp = new int[to+1];
            for (int i = 0; i <= to; i++) {
                temp[i] = str[i];
            }
            result.add(temp);
        }
        for (int i = from; i <= to; i++) {

                int s1 = str[i];
                str[i] = str[from];
                str[from] = s1;
                pailie(str, from + 1, to, result);
                int s2 = str[i];
                str[i] = str[from];
                str[from] = s2;

        }
    }
}
