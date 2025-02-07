import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[] weight;
    static int[] value;
    static int[][] dp;

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        weight = new int[n+1];
        value = new int[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        // 직전 값을 활용하여 i번째 아이템을 선택할지, 하지 않을지 계산
        dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= k; w++) {
                // 배낭 용량보다 아이템의 무게가 큰 경우, 선택할 수 없음
                if (weight[i] > w) {
                    dp[i][w] = dp[i-1][w];
                } else {
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w - weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}