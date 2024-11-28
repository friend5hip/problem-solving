import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int L = str.length();
        
        // shift 전 문자열 출력
        System.out.println(str);
        
        // L번 반복하면서 출력
        for (int i = 0; i < L; i++) {
            str = str.substring(L - 1, L) + str.substring(0, L - 1);
            System.out.println(str);
        }
    }
}