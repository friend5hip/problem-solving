import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        str = str.substring(0, 1) + str.substring(2, str.length() - 2) + str.substring(str.length() - 1, str.length());

        System.out.print(str);
    }
}