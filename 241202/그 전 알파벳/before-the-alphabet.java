import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 소문자 알파벳 ch를 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char ch = str.charAt(0);

        // 바로 전 소문자로 변환
        int prevCh = (int) ch - 1;
        // a 전 문자는 z로
        if (prevCh < 97) {
            prevCh += 26;
        }

        // 출력
        System.out.println((char) prevCh);
    }

}