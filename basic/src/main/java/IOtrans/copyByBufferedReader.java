package IOtrans;

import java.io.*;

/**
 * @auther Lucas
 * @date 2019/1/9 21:15
 */
public class copyByBufferedReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Tang\\java_exercise\\java_study\\main\\IOtrans\\file\\buffered.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\Tang\\java_exercise\\java_study\\main\\IOtrans\\buffered.txt"));
        String line;
        while ((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
