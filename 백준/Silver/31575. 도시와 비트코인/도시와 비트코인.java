import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] grid;
    static int[][] visited;
    static Queue<int[]> queue;
    static int[] dx = new int[]{1, 0}; // 아래쪽, 오른쪽 방문
    static int[] dy = new int[]{0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        grid = new int[m+1][n+1];
        visited = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 시작 포인트
        visited[1][1] = 1;
        queue = new LinkedList<>();
        queue.add(new int[]{1, 1});

        System.out.println(bfs() ? "Yes" : "No");
    }

    static boolean bfs() {
        // 방문할 곳이 없을 때까지
        while (!queue.isEmpty()) {
            // 현재 방문중인 위치
            int[] currentPosition = queue.poll();
            int x = currentPosition[0];
            int y = currentPosition[1];
            // 오른쪽, 아래쪽으로만 이동 가능
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 격자 범위 내의 방문 중이지 않은, 방문 가능한 위치일 경우, 탐색
                if (nx > 0 && ny > 0 && nx <= m && ny <= n && visited[nx][ny] == 0 && grid[nx][ny] == 1) {
                    visited[nx][ny] = 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return visited[m][n] == 1;
    }
}