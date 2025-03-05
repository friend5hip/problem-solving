import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, currentSafeAreas, maxSafeAreas;
    static int[][] grid;
    static int[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        int maxLevel = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                maxLevel = Math.max(maxLevel, grid[i][j]);
            }
        }

        // 안전 영역의 최대 개수를 구해야 한다.
        // 모든 비의 양에서의 안전 영역을 체크해본다.
        for (int i = 0; i < maxLevel; i++) {
            visited = new int[n][n];
            currentSafeAreas = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (grid[r][c] > i && visited[r][c] == 0) {
                        dfs(r, c, i);
                        currentSafeAreas++;
                    }
                }
            }
            maxSafeAreas = Math.max(maxSafeAreas, currentSafeAreas);
        }
        System.out.println(maxSafeAreas);
    }

    public static void dfs(int r, int c, int unsafeLevel) {
        visited[r][c] = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (nr >= 0 && nc >= 0 && nr < n && nc < n
                && visited[nr][nc] == 0 && grid[nr][nc] > unsafeLevel) {
                dfs(nr, nc, unsafeLevel);
            }
        }
    }
}
