import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int m, n, h;
    static int[][][] boxes;
    static boolean[][][] visited;
    static Queue<int[]> queue;
    static int[] dx = new int[]{0, 0, 1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 0, 0, -1, 1};
    static int[] dz = new int[]{1, -1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 가로
        n = Integer.parseInt(st.nextToken()); // 세로
        h = Integer.parseInt(st.nextToken()); // 높이

        boxes = new int[h][n][m];
        for (int f = 0; f < h; f++) {
            for (int r = 0; r < n; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < m; c++) {
                    boxes[f][r][c] = Integer.parseInt(st.nextToken());
                }
            }
        }

        queue = new ArrayDeque<>();
        visited = new boolean[h][n][m];
        for (int f = 0; f < h; f++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (boxes[f][r][c] == 1) {
                        visited[f][r][c] = true;
                        queue.add(new int[]{f, r, c});
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        int days = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int currentDepth = 0; currentDepth < size; currentDepth++) {
                int[] curr = queue.poll();
                int currH = curr[0];
                int currR = curr[1];
                int currC = curr[2];

                for (int i = 0; i < 6; i++) {
                    int newH = currH + dz[i];
                    int newR = currR + dx[i];
                    int newC = currC + dy[i];
                    if (newR >= 0 && newC >= 0 && newR < n && newC < m && newH >= 0 && newH < h
                            && !visited[newH][newR][newC]
                            && boxes[newH][newR][newC] == 0) {
                        visited[newH][newR][newC] = true;
                        boxes[newH][newR][newC] = 1;
                        queue.add(new int[]{newH, newR, newC});
                    }
                }
            }
            days++; // 한 depth가 끝나면 1일 증가
        }
        // 익지 않은 토마토 체크
        for (int f = 0; f < h; f++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (boxes[f][r][c] == 0) {
                        return -1;
                    }
                }
            }
        }

        return days - 1;
    }
}
