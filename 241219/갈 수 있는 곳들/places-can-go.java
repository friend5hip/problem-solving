import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static final int MAX_NUM = 100;
    static int[][] grid = new int[MAX_NUM][MAX_NUM];
    static int[][] visited = new int[MAX_NUM][MAX_NUM];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // n * n 크기 격자 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        for (int l = 0; l < k; l++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st3.nextToken()) - 1;
            int c = Integer.parseInt(st3.nextToken()) - 1;

            q.add(new int[]{r, c});
            BFS();
        }

        System.out.print(count);
    }

    static void BFS() {
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];

            // 방문 여부 체크
            if (visited[r][c] == 1) continue;
            visited[r][c] = 1;

            // 0이면 방문 가능한 칸으로 카운트
            if (grid[r][c] == 0) {
                count++;
            } else {
                continue;
            }

            // 방문 가능 여부 체크 후 방문
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;

                q.add(new int[]{nr, nc});
            }
        }
    }
}