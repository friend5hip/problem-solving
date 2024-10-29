import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] strArr = new String[n];
        int cnt = 0;
        int length = 0;
        for (int i = 0; i < n; i++) {
            strArr[i] = br.readLine();
            length += strArr[i].length();
            if (strArr[i].charAt(0) == 'a') {
                cnt++;
            }
        }

        System.out.print(length + " " + cnt);
    }
}