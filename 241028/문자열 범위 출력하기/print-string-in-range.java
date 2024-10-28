import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();

        for (int i = 2; i < 10; i++) {
            System.out.print(str.charAt(i));
        }
    }
}