import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        String[] strArr = new String[10];
        for (int i = 0; i < 10; i++) {
            strArr[i] = st.nextToken();
            if (i % 2 == 0) {
                System.out.println(strArr[i]);
            }
        }
    }
}