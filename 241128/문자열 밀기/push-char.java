import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // 가장 앞에 있는 문자를 맨뒤로
        s = s.substring(1) + s.substring(0, 1);

        // 출력
        System.out.println(s);
    }
}