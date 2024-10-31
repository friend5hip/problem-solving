import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = new String[10];
        for (int i = 0; i < 10; i++) {
            strArr[i] = br.readLine();
        }

        char endChar = br.readLine().charAt(0);

        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            if (strArr[i].charAt(strArr[i].length() - 1) == endChar) {
                System.out.println(strArr[i]);
                cnt++;
            }
        }
        if (cnt == 0) {
            System.out.print("None");
        }
    }
}