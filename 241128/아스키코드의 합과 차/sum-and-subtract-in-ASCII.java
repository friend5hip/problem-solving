import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 영문자 2개 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        char[] chars = input.toCharArray();
        int a = chars[0];
        int b = chars[2];

        // 두 문자의 합과 차
        int sum = a + b;
        int sub = a > b ? a - b : b - a;

        // 출력
        bw.write(sum + " " + sub + "\n");
        bw.flush();
        bw.close();
    }
}