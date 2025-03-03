import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, t;
    static int[] dp, answers;
    static int[] oneTwoThree = {1, 2, 3};

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        answers = new int[t];

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            dp = new int[12];
            dp[0] = 1; dp[1] = 1;
            dp[2] = 2; dp[3] = 4;

            for (int j = 4; j <= n; j++) { // 4부터 더해 n까지 만들기
                for (int oneOfThem : oneTwoThree) { // 1부터 더하기
                    dp[j] += dp[j - oneOfThem];
                }
            }
            answers[i] = dp[n];
        }

        for (int answer : answers) {
            System.out.println(answer);
        }
    }
}