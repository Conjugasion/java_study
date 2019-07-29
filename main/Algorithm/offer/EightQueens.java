package algorithm.offer;


/**
 * @author Lucas
 * @date 2019/7/26 20:33
 * 八皇后问题，回溯
 * 将八个皇后摆在一张8*8的国际象棋棋盘上，使每个皇后都无法吃掉别的皇后，一共有多少种摆法？
 * 可以吃掉与其在同一行、列和斜线的敌方棋子
 */
public class EightQueens {
    static int count = 0;
    static int[][] chess = new int[8][8];          // 初始化棋盘，未放置为0，放置为1
    public static void main(String[] args) {
        findQueens(0);
        System.out.println(count);
    }

    static void findQueens(int row){
        if (row>7){
            count++;
            print();
            return;
        }
        for (int col = 0; col < 8; col++) { // 深度回溯,递归算法
            if (check(row, col)){           // 检查皇后摆放是否合适
                chess[row][col] = 1;
                findQueens(row+1);
                chess[row][col] = 0;        // 不管成功与否，都要清理棋盘，以备下次使用
            }
        }
    }

    static boolean check(int row, int col){ // 判断节点是否合适
        for (int i = 0; i < 8; i++) {       // 不同行 col列上是否已经有皇后
            if (chess[i][col]==1){
                return false;
            }
        }
        for (int i = 0; i < 8; i++) {      // 不同列 row行上是否已经有皇后
            if (chess[row][i]==1){
                return false;
            }
        }
        for (int i = row-1, j = col-1; i>=0&&j>=0 ; i--, j--) {   // 左对角线，只需要关注之前行即可
            if (chess[i][j]==1){
                return false;
            }
        }
        for (int i = row-1, j= col+1; i>=0&&j<8 ; i--,j++) {    // 右对角线，只需要关注之前行即可
            if (chess[i][j]==1){
                return false;
            }
        }
        return true;
    }

    static void print(){    // 打印结果
        System.out.print("方案"+count+":"+"\n");
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chess[i][j]==1){
                    System.out.print("o ");
                }
                else{
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
