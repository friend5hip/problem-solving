import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 격자의 크기 N과 N * N 크기의 격자에 대한 정보를 입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 격자를 완전 탐색하면서 최댓값을 계산
        int maximumValue = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 2; j++) {
                maximumValue = Math.max(maximumValue, grid[i][j] + grid[i][j+1] + grid[i][j+2]);
            }
        }

        // 최댓값 출력
        System.out.print(maximumValue);
    }
}