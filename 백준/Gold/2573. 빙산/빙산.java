import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, years;
    static int[][] icebergs;
    static int[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        icebergs = new int[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                icebergs[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // bfs를 어디서 시작할건지?
        // 모든 0이 아닌 위치를 다 넣고 bfs?
        // 0을 만나면 -1 시킴
        // bfs를 호출한 횟수가 빙산 덩어리의 개수가 될듯
        while (true) {
            int icebergCount = 0;
            visited = new int[n][m];
            // 빙산을 발견하면 그 빙산을 탐색
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (icebergs[r][c] > 0 && visited[r][c] == 0) {
                        icebergCount++;
                        bfs(r, c);
                    }
                }
            }

            if (icebergCount >= 2) {
                System.out.println(years);
                return;
            } else if (icebergCount == 0) {
                System.out.println(0);
                return;
            }

            meltIcebergs(); // 빙산을 한 번에 녹임
            years++; // 1년 경과
        }
    }

    public static void bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[r][c] = 1;
        queue.add(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currR = curr[0];
            int currC = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = currR + dx[i];
                int nc = currC + dy[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m
                    && visited[nr][nc] == 0 && icebergs[nr][nc] > 0) {
                        visited[nr][nc] = 1;
                        queue.add(new int[]{nr, nc});
                }
            }
        }
    }

    public static void meltIcebergs() {
        int[][] melt = new int[n][m];
        // 녹일 양을 계산
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (icebergs[r][c] > 0) {
                    int waterCount = 0;
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dx[i];
                        int nc = c + dy[i];

                        if (nr >= 0 && nc >= 0 && nr < n && nc < m && icebergs[nr][nc] == 0) {
                            waterCount++;
                        }
                    }
                    melt[r][c] = waterCount;
                }
            }
        }
        // 빙산을 녹임
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                icebergs[r][c] = Math.max(0, icebergs[r][c] - melt[r][c]);
            }
        }
    }
}

