package Algorithm.seach;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Lucas
 * @date 2019/8/6 10:28
 * 图的深度遍历
 * 0 1 4 6 5 3 2
 */
public class MapDFS {
    public static void main(String[] args) {
        int[][] map = {{0, 1, 1, 1, 0, 0, 0},
                       {1, 0, 0, 0, 1, 0, 0},
                       {1, 0, 0, 0, 1, 1, 0},
                       {1, 0, 0, 0, 0, 1, 0},
                       {0, 1, 1, 0, 0, 0, 1},
                       {0, 0, 1, 1, 0, 0, 1},
                       {0, 0, 0, 0, 1, 1, 0}};

        int[] mark1 = new int[map.length];     // 标记已达顶点
        int[] mark2 = new int[map.length];
        System.out.print("深度遍历图："); dfs(map, mark1, 0);
        System.out.println();
        System.out.print("宽度遍历图："); bfs(map, mark2, 0);

    }

    // 深度遍历图， 递归
    static void dfs(int[][] map, int[] mark, int x){
        System.out.print(x + " ");
        mark[x] = 1;

        for (int i = 0; i < map[x].length; i++) {
            // 从x点到i有路可达， 并且i点还未到过
            if (map[x][i]==1 && mark[i]==0){
                dfs(map, mark, i);
            }
        }
    }

    // 宽度遍历图，使用队列
    static void bfs(int[][] map, int[] mark, int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        mark[x] = 1;

        while (!q.isEmpty()){
            x = q.poll();
            System.out.print(x + " ");
            for (int i = 0; i < map[x].length; i++) {
                // 从x点到i有路可达， 并且i点还未到过
                if (map[x][i]==1 && mark[i]==0){
                    q.offer(i);
                    mark[i] = 1;
                }
            }
        }

    }
}
