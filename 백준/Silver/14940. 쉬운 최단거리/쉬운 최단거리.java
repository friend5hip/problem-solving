import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, m;
    static int[][] grid;
    static int[][] visited;
    static int[][] distances;
    static Queue<int[]> queue;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new int [n][m];
        distances = new int[n][m];
        queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 2) {
                    visited[i][j] = 1;
                    distances[i][j] = 0;
                    queue.add(new int[]{i, j});
                }
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(distances[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    public static void bfs() {
        int distance = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int currR = curr[0];
                int currC = curr[1];

                for (int j = 0; j < 4; j++) {
                    int nr = currR + dx[j];
                    int nc = currC + dy[j];

                    if (nr >= 0 && nc >= 0 && nr < n && nc < m
                            && visited[nr][nc] == 0 && grid[nr][nc] == 1) {
                        visited[nr][nc] = 1;
                        distances[nr][nc] = distance;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
            distance++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    distances[i][j] = -1;
                }
            }
        }
    }
}