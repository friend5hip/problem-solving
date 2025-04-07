import java.io.*;
import java.util.*;

class Main {
    static int n;
    static char[][] painting;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        painting = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                painting[i][j] = str.charAt(j);
            }
        }

        visited = new boolean[n][n];
        int normalCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    normalCount++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (painting[i][j] == 'G') {
                    painting[i][j] = 'R';
                }
            }
        }

        visited = new boolean[n][n];
        int colorBlindCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    colorBlindCount++;
                }
            }
        }

        System.out.println(normalCount + " " + colorBlindCount);
    }

    static void bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[r][c] = true;
        queue.add(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dx[i];
                int nc = curr[1] + dy[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc]) continue;
                if (painting[nr][nc] == painting[curr[0]][curr[1]]) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
}