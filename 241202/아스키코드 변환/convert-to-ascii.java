import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 영문자 a와 정수 b를 입력 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // a는 정수로, b는 영문자로 변환해서 출력
        StringTokenizer st = new StringTokenizer(str, " ");
        char a = st.nextToken().charAt(0);

        System.out.print((int) a + " " + (char) Integer.parseInt(st.nextToken()));
    }
}