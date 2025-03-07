import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int[] timeToWithdraw = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            timeToWithdraw[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬
        Arrays.sort(timeToWithdraw);
        // 누적 합
        int[] dp = new int[n];
        dp[0] = timeToWithdraw[0];
        int sum = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] + timeToWithdraw[i];
            sum += dp[i];
        }
        System.out.println(sum);
    }
}