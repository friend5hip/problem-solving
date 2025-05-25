import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k;
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        // dp[k][n]은 i개의 숫자를 사용했을 때, n이 되는 경우의 수  
        long[][] dp = new long[k + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            long sum = 0;
            for (int j = 0; j <= n; j++) {
                sum = (sum + dp[i - 1][j]) % MOD;
                dp[i][j] = sum;
            }
        }

        System.out.println(dp[k][n]);
    }
}
