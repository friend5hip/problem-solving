import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        
        for (int i = 0; i < 10; i++) {
            System.out.println(st.nextToken());
        }

    }
}