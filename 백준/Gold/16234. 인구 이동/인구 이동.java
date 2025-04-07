import java.io.*;
import java.util.*;

public class Main {
    static int n, l, r, days;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        // 두 칸의 차이가 l 이상, r 이하면 하루 동안 이동 가능
        // 인접한 칸을 이동하면 이동한 칸들은 해당 하루 동안 연합이 됨
        // 모든 이동이 끝나고, 연합인 칸의 인구는 (모든 칸의 수 / 칸)이 됨
        // 이동이 끝나면 하루 증가
        while (true) {
            visited = new boolean[n][n];
            boolean moved = false;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (!visited[r][c]) {
                        if (bfs(r, c)) {
                            moved = true;
                        }
                    }
                }
            }
            if (!moved) break;
            days++;
        }

        System.out.println(days);
    }

    static boolean bfs(int x, int y) {
        queue = new ArrayDeque<>();
        List<int[]> union = new ArrayList<>(); // 연합 국가들을 저장

        visited[x][y] = true;
        queue.add(new int[]{x, y});
        union.add(new int[]{x, y});
        int unionSum = map[x][y];

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dx[i];
                int nc = curr[1] + dy[i];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                int diff = Math.abs(map[curr[0]][curr[1]] - map[nr][nc]);
                if (!visited[nr][nc] && (diff >= l && diff <= r)) {
                    visited[nr][nc] = true;
                    union.add(new int[]{nr, nc});
                    queue.add(new int[]{nr, nc});
                    unionSum += map[nr][nc];
                }
            }
        }

        // 이동이 일어나지 않음
        if (union.size() <= 1) {
            return false;
        }

        // 연합 체크 후 연합인 칸들의 새로운 인구 반영
        int eachPopulation = unionSum / union.size();
        for (int[] nation : union) {
            map[nation[0]][nation[1]] = eachPopulation;
        }

        return true;
    }
}
