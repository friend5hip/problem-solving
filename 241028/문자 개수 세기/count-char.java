import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        char str2 = br.readLine().charAt(0);
        
        int cnt = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2) {
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}