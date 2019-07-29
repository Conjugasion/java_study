package HeapDump;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Lucas
 * @date 2019-06-05 20:48
 */
public class CommandDump {
    public static void main(String[] args) throws IOException {
        String[] command = {"/bin/sh", "-c", "/Users/supershan/javaDump.sh"};
        Process exec = Runtime.getRuntime().exec(command);
        InputStream inputStream = exec.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while((line=bufferedReader.readLine())!=null)
        {
            System.out.println(line);
        }
    }
}
