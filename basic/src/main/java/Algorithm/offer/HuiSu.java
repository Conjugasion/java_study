package Algorithm.offer;

/**
 * @author Lucas
 * @date 2019/7/26 11:12
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，
 * 则之后不能再次进入这个格子。 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径
 */
public class HuiSu {
    public static void main(String[] args) {
        HuiSu huiSu = new HuiSu();
        char[] matrix = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] str = {'b','c','c','e','d'};
        boolean b = huiSu.hasPath(matrix, 3, 4, str);
        System.out.println(b);

    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(str.length==0) return true;
        if(matrix.length==0||str.length>matrix.length) return false;
        //标志位，初始化为0
        int[] hasPass = new int[matrix.length];   // 0表示还没经过，1表示已经经过
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                //int[] hasPass = new int[matrix.length];   // 可以挪到内部
                //循环遍历二维数组，找到起点等于str第一个元素的值，再递归判断四周是否有符合条件的----回溯法
                if(judge(matrix, i, j, rows, cols, str, 0, hasPass)){
                    return true;
                }
            }
        }
        return false;
    }

    // 以(x,y)为起点开始寻找
    //judge(初始矩阵，索引行坐标i，索引纵坐标j，矩阵行数，矩阵列数，待判断的字符串，字符串索引初始为0即先判断字符串的第一位)
    boolean judge(char[] matrix, int x, int y, int rows, int cols, char[] str, int k, int[] hasPass){
        //先根据i和j计算匹配的第一个元素转为一维数组的位置
        int index = x*cols+y;
        //递归终止条件
        if(x<0||y<0||x>=rows||y>=cols||matrix[index]!=str[k]||hasPass[index]==1) return false;
        //若k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
        if(k==str.length-1) return true;
        //要走的第一个位置置为1，表示已经走过了
        hasPass[index] = 1;
        //回溯，递归寻找，每次找到了就给k加一，找不到，还原
        if(judge(matrix, x-1, y, rows, cols, str, k+1, hasPass)||
                judge(matrix, x+1, y, rows, cols, str, k+1, hasPass)||
                judge(matrix, x, y-1, rows, cols, str, k+1, hasPass)||
                judge(matrix, x, y+1, rows, cols, str, k+1, hasPass)){
            return true;
        }
        //走到这，说明这一条路不通，还原，再试其他的路径
        hasPass[index] = 0;
        return false;
    }
}
