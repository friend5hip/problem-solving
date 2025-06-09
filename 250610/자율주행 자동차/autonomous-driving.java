import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] cleaned;
    static int r, c, d;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        cleaned = new boolean[n][m];

        System.out.println(cleanRoom());
    }

    static int cleanRoom() {
        int cleanedPoints = 0;

        while (true) {
            if (!cleaned[r][c]) {
                cleaned[r][c] = true;
                cleanedPoints++;
            }

            boolean cleanedOrWallEncountered = true;
            for (int i = 0; i < 4; i++) {
                int nd = (d + 3) % 4; // 반시계 방향으로 회전
                int nr = r + dx[nd];
                int nc = c + dy[nd];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (map[nr][nc] == 0 && !cleaned[nr][nc]) {
                    r = nr; c = nc; d = nd;
                    cleanedOrWallEncountered = false;
                    break;
                }

                d = nd; // 반시계 방향으로 회전
            }
            // 청소된 칸이거나 벽을 만난 경우
            if (cleanedOrWallEncountered) {
                int toBack = (d + 2) % 4;
                int nr = r + dx[toBack];
                int nc = c + dy[toBack];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (map[nr][nc] == 0) {
                    r = nr; c = nc;
                } else {
                    break;
                }
            }
        }

        return cleanedPoints;
    }
}
