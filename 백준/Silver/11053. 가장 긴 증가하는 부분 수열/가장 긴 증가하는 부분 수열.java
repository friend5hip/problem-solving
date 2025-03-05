import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n]; // sequence[i]에서의 LIS
        Arrays.fill(dp, 1); // 모든 수는 자기 자신을 포함해야 함
        for (int i = 1; i < n; i++) {
            // 현재 수보다 왼쪽에 있는 수보다 큰 경우, 해당 숫자의 LIS와 비교
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]); // LIS 찾기
        }

        System.out.println(max);
    }
}
