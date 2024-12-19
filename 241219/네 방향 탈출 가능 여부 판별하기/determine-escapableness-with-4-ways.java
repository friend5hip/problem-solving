import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs() ? 1 : 0);
    }

    static boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            if (x == n - 1 && y == m - 1) return true;

            for (int i = 0; i < 4; i++) {  // 4방향 탐색
                int nx = x + dx[i], ny = y + dy[i];
                if (isValid(nx, ny)) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return false;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && !visited[x][y] && grid[x][y] == 1;
    }
}
