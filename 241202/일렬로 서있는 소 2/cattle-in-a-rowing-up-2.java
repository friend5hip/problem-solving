import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 첫 번째 줄엔 N
        // 두 번째 줄엔 N마리의 소의 키
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String height = br.readLine();
        int[] heightOfN = new int[N];

        StringTokenizer st = new StringTokenizer(height);
        int idx = 0;
        while (st.hasMoreTokens()) {
            heightOfN[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }

        // 모든 소의 키를 탐색
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    // i번째 키 <= j번째 키 <= k번째 키일 경우 카운트
                    if (heightOfN[i] <= heightOfN[j] && heightOfN[j] <= heightOfN[k] && heightOfN[i] <= heightOfN[k]) {
                        count++;
                    }
                }
            }
        }

        // 카운트를 출력
        System.out.println(count);
    }
}