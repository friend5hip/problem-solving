import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(findMaxPath(n, triangle));
    }

    public static int findMaxPath(int n, int[][] triangle) {
        // dp 배열 초기화
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];

        // 삼각형의 모든 위치에서 최댓값을 구한다.
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][0]; // 삼각형의 왼쪽 가장자리
                } else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][i]; // 삼각형의 오른쪽 가장자리
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j]; // 중간 지점
                }
            }
        }

        int maxSum = dp[n-1][0];
        for (int i = 1; i < n; i++) {
            maxSum = Math.max(maxSum, dp[n-1][i]);
        }

        return maxSum;
    }
}
