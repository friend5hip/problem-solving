import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine().replaceAll(" ", "");
        String str2 = br.readLine().replaceAll(" ", "");

        System.out.print(str1 + str2);
    }
}