/**
 * @author tangdongfan
 * @date 2021/1/26 17:20
 * @description 求和Groovy版
 */
class SumGroovy{

    static void main(String[] args) {
        int n = 1000000000
        int sum = 0
        long start = System.currentTimeMillis()
        for (int i = 0; i < n; i++) {
            sum += i
        }
        long end = System.currentTimeMillis()
        System.out.println("求和耗时: " + (end-start))
    }
}
 
