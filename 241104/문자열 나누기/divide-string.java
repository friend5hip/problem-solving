import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        String replaced = str.replaceAll(" ", "");

        for (int i = 0; i < replaced.length(); i++) {
            System.out.print(replaced.charAt(i));
            if ((i + 1) % 5== 0) {
                System.out.println();
            }
        }
    }
}