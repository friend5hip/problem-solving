import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 문자열 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();

        // 문자열의 모든 경우를 탐색
        char[] AtoChar = A.toCharArray();
        int count = 0;
        for (int i = 0; i < AtoChar.length; i++) {
            for (int j = i+1; j < AtoChar.length; j++) {
                // '('으로 시작하고 현재 괄호가 다를 경우 카운트
                if (AtoChar[i] == '(' && AtoChar[i] != (AtoChar[j])) {
                    count++;
                }
            }
        }

        // 출력
        System.out.println(count);
    }
}