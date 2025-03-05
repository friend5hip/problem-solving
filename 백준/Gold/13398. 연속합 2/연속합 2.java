import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[n]; // 수를 제거하지 않는 최대 연속합
        int[] dp2 = new int[n]; // 하나의 수를 제거할 때의 최대 연속합
        dp1[0] = sequence[0]; // 첫 번째 수를 선택
        dp2[0] = 0; // 첫 번째를 선택하지 않음
        int maxSum = dp1[0];
        for (int i = 1; i < n; i++) {
            // 이번 수를 선택할지, 다시 수를 더하기 시작할지 선택
            dp1[i] = Math.max(dp1[i-1] + sequence[i], sequence[i]);
            // 현재 수를 제거하거나, 이전에 제거한 경우, 현재 수를 선택
            dp2[i] = Math.max(dp1[i-1], dp2[i-1] + sequence[i]);
            // 최댓값 계산
            maxSum = Math.max(Math.max(maxSum, dp1[i]), dp2[i]);
        }

        System.out.println(maxSum);
    }
}
