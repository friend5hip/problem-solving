import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[] coins, dp, answers;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        answers = new int[t];

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            coins = new int[n];
            for (int j = 0; j < n; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }
            m = Integer.parseInt(br.readLine());

            answers[i] = countCases();
        }

        for (int answer : answers) {
            System.out.println(answer);
        }
    }

    public static int countCases() {
        dp = new int [m + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= m; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[m];
    }
}