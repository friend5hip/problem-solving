import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // a, b를 입력받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        // B가 A의 부분 문자열이 아닐 때까지 반복
        while (a.contains(b)) {
            // A에서 B를 제거
            int index = a.indexOf(b);
            a = a.substring(0, index) + a.substring(index + b.length(), a.length());
        }
        System.out.println(a);
    }
}