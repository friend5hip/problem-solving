import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (isPrime(number)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false; // 2 미만은 소수가 아님
        if (num == 2) return true; // 2는 소수
        if (num % 2 == 0) return false; // 짝수는 소수가 아님

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
