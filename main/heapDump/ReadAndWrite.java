package heapDump;

import java.io.*;

/**
 * @author Lucas
 * @date 2019-06-08 15:00
 */
public class ReadAndWrite {
    public static void main(String[] args) throws IOException {
        String[] command = {"/bin/sh", "-c", "/Users/supershan/javaDump.sh"};
        Process exec = Runtime.getRuntime().exec(command);
        InputStream is = exec.getInputStream();
        BufferedReader rd1 = new BufferedReader(new InputStreamReader(is));

        FileOutputStream fos = new FileOutputStream("/Users/supershan/javaProject/java_study/main/heapDump/file/javaDump.txt");
        BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(fos));
        String line1;
        while((line1=rd1.readLine())!=null)
        {
            System.out.println(line1);
            bw1.write(line1);
            bw1.newLine();
        }
        bw1.close();
        rd1.close();
    }

}
