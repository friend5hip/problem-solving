import java.io.*;
import java.util.*;

public class Main {
    public static String[] drawStars(int n) {
        if (n == 1) {
            return new String[]{"*"};
        }

        String[] stars = drawStars(n/3);  // 이전 단계의 패턴 생성
        String[] result = new String[n];

        for (int i = 0; i < n/3; i++) {
            result[i] = stars[i].repeat(3);  // 현재 패턴의 가로 확장
        }
        for (int i = 0; i < n/3; i++) {
            result[i + n/3] = stars[i] + " ".repeat(n/3) + stars[i];  // 가운데 공백 처리
        }
        for (int i = 0; i < n/3; i++) {
            result[i + 2*n/3] = stars[i].repeat(3); // 아래쪽 패턴
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] result = drawStars(n);
        for (String line : result) {
            System.out.println(line);
        }
    }
}