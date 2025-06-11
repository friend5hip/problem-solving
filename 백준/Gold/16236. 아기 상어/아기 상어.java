import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0}; // 상, 좌, 하, 우
    static int[] dy = {0, -1, 0, 1};
    static class Shark {
        int r, c, size, fish, dist;
        public Shark(int r, int c, int size, int fish, int dist) {
            this.r = r;
            this.c = c;
            this.size = size;
            this.fish = fish;
            this.dist = dist;
        }
    }
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        // 아기 상어의 크기는 처음 2
        // 아기 상어는 자신보다 큰 물고기가 있는 칸을 제외하고 모두 지나갈 수 있다.
        // 자신보다 작은 물고기는 먹을 수 있다. 크기가 같은 경우 지나갈 수는 있지만 먹을 수는 없다.
        // 먹을 수 있는 물고기가 없으면 종료한다.
        // 먹을 수 있는 물고기가 1마리라면, 물고기를 먹으러
        // 더 많다면, 거리가 가장 가까운 물고기를 먹으러
        // 거리가 가까운 물고기가 많으면, 가장 위 물고기, 그러한 물고기가 여러 마리면 가장 왼쪽 물고기
        // 크기와 같은 수를 먹을 때마다 크기가 1씩 증가
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int[] start = new int[2]; // 시작 위치
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                String info = st.nextToken();
                if (info.equals("9")) {
                    start[0] = i; start[1] = j;
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = Integer.parseInt(info);
            }
        }

        Shark shark = new Shark(start[0], start[1], 2, 0, 0);
        while (true) {
            Shark next = bfs(shark);
            if (next == null) break; // 먹을 수 있는 물고기가 없으면 종료한다.
            shark = next;
        }

        System.out.println(shark.dist);
    }

    static Shark bfs(Shark shark) {
        Queue<int[]> queue = new ArrayDeque<>();
        PriorityQueue<Shark> candidates = new PriorityQueue<>((a, b) -> {
            if (a.dist != b.dist) return a.dist - b.dist;
            if (a.r != b.r) return a.r - b.r;
            return a.c - b.c;
        });

        visited = new boolean[n][n];
        queue.add(new int[]{shark.r, shark.c, 0});
        visited[shark.r][shark.c] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], dist = curr[2];

            if (map[r][c] != 0 && map[r][c] < shark.size) {
                candidates.add(new Shark(r, c, shark.size, shark.fish, dist));
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (visited[nr][nc] || shark.size < map[nr][nc]) continue;

                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc, dist + 1});
            }
        }

        if (!candidates.isEmpty()) {
            Shark target = candidates.poll();
            map[shark.r][shark.c] = 0;
            map[target.r][target.c] = 0;
            int newFish = shark.fish + 1;
            int newSize = shark.size;
            if (newFish >= shark.size) {
                newSize++;
                newFish = 0;
            }
            return new Shark(target.r, target.c, newSize, newFish, shark.dist + target.dist);
        } else {
            return null;
        }
    }

}