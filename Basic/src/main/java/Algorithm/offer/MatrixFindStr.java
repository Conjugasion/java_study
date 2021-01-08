package Algorithm.offer;

/**
 * @author Lucas
 * @date 2019/9/17 15:15
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class MatrixFindStr {
    public static void main(String[] args) {

        boolean b = find("ABCESFCSADEE".toCharArray(), 3, 4, 0, 0, new int[12],"ABCCED".toCharArray(),  0);
        System.out.println(b);
    }

    static boolean find(char[] matrix, int rows, int cols, int x, int y, int[] mark, char[] str, int k){
        int index = x*cols+y;
        if(x<0||x>=rows||y<0||y>=cols||mark[index]==1||str[k]!=matrix[index]) return false;
        if(k==str.length-1) return true;
        mark[index] = 1;
        if( find(matrix, rows, cols, x+1, y, mark, str, k+1)||
            find(matrix, rows, cols, x-1, y, mark, str, k+1)||
            find(matrix, rows, cols, x, y+1, mark, str, k+1)||
            find(matrix, rows, cols, x, y-1, mark, str, k+1)){
            return true;
        }
        mark[index] = 0;
        return false;
    }
}
