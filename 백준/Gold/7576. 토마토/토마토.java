import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] grid;
    static boolean[][] visited;
    static int m, n, count;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
        queue = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1) {
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }

        bfs();
    }

    public static void bfs() throws IOException {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = current[0] + dx[i];
                int nextC = current[1] + dy[i];

                if (nextR >= 0 && nextC >= 0 && nextR < n && nextC < m
                && !visited[nextR][nextC] && grid[nextR][nextC] == 0) {
                    visited[nextR][nextC] = true;
                    grid[nextR][nextC] = grid[current[0]][current[1]] + 1;
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }

        int maxDays = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 0) {
                    bw.write("-1\n");
                    bw.flush();
                    bw.close();
                    return;
                }
                maxDays = Math.max(maxDays, grid[r][c]);
            }
        }

        bw.write((maxDays - 1) + "\n");
        bw.flush();
        bw.close();
    }
}