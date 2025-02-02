import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer[] dp = new Integer[n];
        int[] sequence = new int[n];
        
        // n개의 수열
        int i = 0;
        while (st.hasMoreTokens()) {
            sequence[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        
        dp[0] = sequence[0];
        int max = sequence[0];
        for (int j = 1; j < n; j++) {
            // (이전 dp + 현재 arr값) 과 현재 arr값 중 큰 것을 dp에 저장
            dp[j] = Math.max(dp[j - 1] + sequence[j], sequence[j]);
            // 최댓값 갱신
            max = Math.max(max, dp[j]);
        }

        System.out.println(max);
    }

}