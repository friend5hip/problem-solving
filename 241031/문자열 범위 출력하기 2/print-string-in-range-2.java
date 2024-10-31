import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int length = Integer.parseInt(br.readLine());

        if (length > str.length()) {
            for (int i = str.length() - 1; i >= 0; i--) {
                System.out.print(str.charAt(i));
            }
        } else {
            for (int i = str.length() - 1; i >= str.length() - length; i--) {
                System.out.print(str.charAt(i));
            }
        }
    }
}