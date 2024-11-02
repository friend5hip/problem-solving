import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String subStr = br.readLine();

        int cnt = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == subStr.charAt(0) && str.charAt(i+1) == subStr.charAt(1)) {
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}