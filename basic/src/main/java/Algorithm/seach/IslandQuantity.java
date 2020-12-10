package Algorithm.seach;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Lucas
 * @date 2019-08-02 14:45
 * 搜索岛屿
 */
public class IslandQuantity {
    public static void main(String[] args) {
        int[][] isLand1 = {{1, 1, 1, 1},
                           {1, 0, 1, 0},
                           {0, 1, 1, 1},
                           {0, 0, 0, 1}};

        int[][] mark1 = new int[isLand1.length][isLand1[0].length];
        int[][] isLand2 = {{1, 1, 1, 1},
                           {1, 0, 1, 0},
                           {0, 1, 1, 1},
                           {0, 0, 0, 1}};

        int[][] mark2 = new int[isLand2.length][isLand2[0].length];


        System.out.println("深度搜索 岛屿数量：" + countBydfs(isLand1, mark1));
        System.out.println("宽度搜索 岛屿数量：" + countBybfs(isLand2, mark2));
    }

    // 遍历isLand数组，如果当前点是陆地且未被访问过，则调用搜索方法，完成搜索后isLand++
    static int countBydfs(int[][] isLand, int[][] mark){
        int num = 0;
        for (int i = 0; i < isLand.length; i++) {
            for (int j = 0; j < isLand[i].length; j++) {
                if (isLand[i][j]==1&&mark[i][j]==0){
                    dfs(isLand, mark, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    static int countBybfs(int[][] isLand, int[][] mark){
        int num = 0;
        for (int i = 0; i < isLand.length; i++) {
            for (int j = 0; j < isLand[i].length; j++) {
                if (isLand[i][j]==1&&mark[i][j]==0){
                    bfs(isLand, mark, i, j);
                    num++;
                }
            }
        }
        return num;
    }


    // DFS深度优先搜索
    // 从某个陆地出发，找到所有与它相连的陆地，并在mark数组中标记出来
    static void dfs(int[][] isLand, int[][] mark, int x, int y){
        mark[x][y] = 1;    // 标记已搜索点
        // 方向数组
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newx = x+dx[i];
            int newy = y+dy[i];

            // 不能超过地图边界
            if (newx>=0&&newy>=0&&newx<isLand.length&&newy<isLand[newx].length){
                // 什么情况继续搜索？
                if (mark[newx][newy]==0&&isLand[newx][newy]==1){
                    dfs(isLand, mark, newx, newy);
                }
            }
        }

    }



    // BFS宽度优先搜索
    // 设置搜索队列，将待搜索的陆地push到队列
    static void bfs(int[][] isLand, int[][] mark, int x, int y){
        Queue<int[]> q = new LinkedList<>();  // 宽度优先搜索队列
        q.offer(new int[]{x,y});
        mark[x][y] = 1;    // 标记已搜索点
        // 方向数组
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()){
            int[] position = q.poll();
            x = position[0];
            y = position[1];

            for (int i = 0; i < 4; i++) {
                int newx = x+dx[i];
                int newy = y+dy[i];

                // 不能超过地图边界
                if (newx>=0&&newy>=0&&newx<isLand.length&&newy<isLand[newx].length){
                    // 如果当前位置未搜索到且为陆地
                    if (mark[newx][newy]==0&&isLand[newx][newy]==1){
                        q.offer(new int[]{newx, newy});
                        mark[newx][newy]=1;
                    }
                }

            }
        }
    }
}
