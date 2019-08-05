package Algorithm.seach;


/**
 * @author Lucas
 * @date 2019-08-02 14:45
 */
public class IslandQuantity {
    public static void main(String[] args) {
        int[][] isLand = {{1, 1, 1, 1},
                          {1, 0, 1, 0},
                          {0, 1, 1, 1},
                          {0, 0, 0, 1}};

        int[][] hasSearch = new int[isLand.length][isLand.length];
        int[] count = new int[1];
        search(isLand, hasSearch, 0, 0, count);
        System.out.println("岛屿数量：" + count[0]);
    }

    //
    static void search(int[][] isLand, int[][] hasSearch, int x, int y, int[] count){

        if (x>=0&&y>=0&&x<isLand.length&&y<isLand.length){
            if (hasSearch[x][y] == 0){
                hasSearch[x][y] = 1;
                if (isLand[x][y] == 1){
                    search(isLand, hasSearch, x-1, y, count);
                    search(isLand, hasSearch, x+1, y, count);
                    search(isLand, hasSearch, x, y-1, count);
                    search(isLand, hasSearch, x, y+1, count);
                }
            }
        }


    }

}
