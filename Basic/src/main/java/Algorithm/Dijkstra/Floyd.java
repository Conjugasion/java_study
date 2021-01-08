package Algorithm.Dijkstra;

/**
 * @author Lucas
 * @date 2019/8/23 20:24
 */
public class Floyd {
    //无穷大
    public static int inf = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 图数据 Data [u, v, cost]
        int[][] datas = {
                {0, 1, 2},
                {0, 2, 6},
                {0, 3, 4},
                {1, 2, 3},
                {2, 0, 7},
                {2, 3, 1},
                {3, 0, 5},
                {3, 2, 12},
        };

        //结点数
        int n = 4;

        //构图
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = inf;
                }
            }
        }
        for (int i = 0; i < datas.length; i++) {
            int a = datas[i][0], b = datas[i][1], c = datas[i][2];
            graph[a][b] = c;
        }

        // 弗洛伊德算法求多源最短路径
        floyd(graph);

        //打印结果
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String s = graph[i][j] == inf ? "∞" : graph[i][j] + "";
                System.out.print(s + '\t');
            }
            System.out.println();
        }
    }

    private static void floyd(int[][] graph) {
        int n = graph.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] != inf && graph[k][j] != inf) {
                        graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
                    }
                }
            }
        }
    }

}
