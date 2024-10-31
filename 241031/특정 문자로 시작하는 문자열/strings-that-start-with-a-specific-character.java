import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] strArr = new String[n];

        for (int i = 0; i < n; i++) {
            strArr[i] = br.readLine();
        }

        char startChar = br.readLine().charAt(0);
        int startCharSum = 0;
        int lengthSum = 0;
        for (int i = 0; i < n; i++) {
            if (strArr[i].charAt(0) == startChar) {
                startCharSum++;
                lengthSum += strArr[i].length();
            }
        }
        System.out.print(startCharSum + " ");
        System.out.printf("%.2f", (double) lengthSum / (double) startCharSum);
    }
}