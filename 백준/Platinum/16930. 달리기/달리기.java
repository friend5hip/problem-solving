import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, k;
    static char[][] map;
    static int[][] visited;
    static int startX, startY, endX, endY;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class State {
        int x, y, time;
        public State(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
            String info = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = info.charAt(j);
            }
        }
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;
        endX = Integer.parseInt(st.nextToken()) - 1;
        endY = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(bfs(startX, startY));
    }

    public static int bfs(int startX, int startY) {
        Queue<State> queue = new ArrayDeque<>();
        queue.add(new State(startX, startY, 0));
        visited[startX][startY] = 0;

        while (!queue.isEmpty()) {
            State curr = queue.poll();
            int x = curr.x;
            int y = curr.y;
            int time = curr.time;

            if (x == endX && y == endY) {
                return time;
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= k; j++) {
                    int nx = x + dx[i] * j;
                    int ny = y + dy[i] * j;

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) break;
                    if (map[nx][ny] == '#') break;
                    if (visited[nx][ny] < time + 1) break; // 더 짧게 방문했으면 이 방향 중단
                    if (visited[nx][ny] == time + 1) continue; // 같은 시간이라면 중복 큐 삽입 막기

                    visited[nx][ny] = time + 1;
                    queue.add(new State(nx, ny, time + 1));
                }
            }
        }

        return -1;
    }
}
