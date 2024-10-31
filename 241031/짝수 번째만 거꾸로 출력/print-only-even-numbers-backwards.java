import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        for (int i = str.length() - 1; i > 0; i--) {
            if (i % 2 != 0) {
                System.out.print(str.charAt(i));
            }
        }
    }
}