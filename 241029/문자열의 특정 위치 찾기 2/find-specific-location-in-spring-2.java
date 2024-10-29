import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] strArr = {"apple", "banana", "grape", "blueberry", "orange"};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char ch = br.readLine().charAt(0);

        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if ((strArr[i].charAt(2) == ch) || (strArr[i].charAt(3) == ch)) {
                System.out.println(strArr[i]);
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}