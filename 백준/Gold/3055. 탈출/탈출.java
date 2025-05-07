import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static char[][] grid;
    static boolean[][] visited;
    static int min = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        grid = new char[r][c];

        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                grid[i][j] = row.charAt(j);
            }
        }

        int minTime = bfs();
        System.out.println(minTime == -1 ? "KAKTUS" : minTime);
    }

    static int bfs() {
        Queue<int[]> waterQueue = new ArrayDeque<>();
        Queue<int[]> hedgehogQueue = new ArrayDeque<>();
        visited = new boolean[r][c];
        
        // 고슴도치와 물, 두 점의 시작 위치 세팅
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 'S') {
                    hedgehogQueue.offer(new int[]{i, j});
                    visited[i][j] = true;
                } else if (grid[i][j] == '*') {
                    waterQueue.offer(new int[]{i, j});
                }
            }
        }

        int time = 0;

        while (!hedgehogQueue.isEmpty()) {
            // 물 이동
            int waterSize = waterQueue.size();
            for (int i = 0; i < waterSize; i++) {
                int[] water = waterQueue.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = water[0] + dx[d];
                    int nc = water[1] + dy[d];

                    if (nr < 0 || nc < 0 || nr >= r || nc >= c) continue;
                    if (grid[nr][nc] == '.') {
                        grid[nr][nc] = '*';
                        waterQueue.offer(new int[]{nr, nc});
                    }
                }
            }

            // 고슴도치 이동
            int hedgehogSize = hedgehogQueue.size();
            for (int i = 0; i < hedgehogSize; i++) {
                int[] curr = hedgehogQueue.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = curr[0] + dx[d];
                    int nc = curr[1] + dy[d];

                    if (nr < 0 || nc < 0 || nr >= r || nc >= c) continue;
                    if (grid[nr][nc] == 'D') return time + 1;
                    if (!visited[nr][nc] && grid[nr][nc] == '.') {
                        visited[nr][nc] = true;
                        hedgehogQueue.offer(new int[]{nr, nc});
                    }
                }
            }

            time++;
        }

        return -1;
    }
}
