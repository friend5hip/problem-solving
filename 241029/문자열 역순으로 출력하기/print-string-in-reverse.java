import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] strArr = new String[4];
        for (int i = 0; i < 4; i++) {
            strArr[i] = br.readLine(); 
        }

        for (int i = 3; i >= 0; i--) {
            System.out.println(strArr[i]);
        }
    }
}