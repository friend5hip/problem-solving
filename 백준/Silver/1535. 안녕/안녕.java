import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] cost = new int[n+1];
        int[] value = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        int health = 100;
        int[][] dp = new int[n+1][health+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= health; j++) {
                // 체력이 현재 선택한 사람에게 소모되는 체력보다 적으면 이전 최댓값 선택
                if (cost[i] >= j) {
                    dp[i][j] = dp[i-1][j];
                // 체력이 남는 경우, 현재 사람을 선택했을 때의 최댓값과 선택하지 않았을 때의 최댓값을 비교 후 갱신
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - cost[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[n][health]);
    }
}