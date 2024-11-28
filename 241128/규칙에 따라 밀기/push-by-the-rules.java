import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 문자열 A, 명령 문자열 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String command = br.readLine();

        // 명령에 따라 문자열 변환
        char[] commandArr = command.toCharArray();
        int L = A.length();
        for (int i = 0; i < command.length(); i++) {
            if (commandArr[i] == 'L') {
                A = A.substring(1, L) + A.substring(0, 1);
            } else {
                A = A.substring(L-1, L) + A.substring(0, L-1);
            }
        }

        // 결과 출력
        System.out.print(A);
    }
}