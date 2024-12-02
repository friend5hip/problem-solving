import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 자연수 5개 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 공백 단위로 자른다.
        StringTokenizer st = new StringTokenizer(str, " ");

        // 출력
        while (st.hasMoreTokens()) {
            System.out.print((char) Integer.parseInt(st.nextToken()) + " ");
        }
    }
}