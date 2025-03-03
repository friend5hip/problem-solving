import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(countCases(n, k, coins));
    }

    public static int countCases(int n, int k, int[] coins) {
        int[] dp = new int[k+1];
        dp[0] = 1; // 기본 조건 (0을 만들기 위한 경우의 수 1)
        
        for (int i = 0; i < n; i++) {
            int coin = coins[i]; // 현재 동전
            for (int j = coin; j <= k; j++) {
                dp[j] += dp[j - coin]; // 현재 동전을 추가함으로써 만들어지는 경우의 수
            }
        }

        return dp[k]; // 합이 k가 되는 경우의 수
    }
}