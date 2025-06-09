import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[][] map;
    static List<int[]> cameras;
    static int[] dx = {0, 1, 0, -1}; // 동, 남, 서, 북
    static int[] dy = {1, 0, -1, 0};
    static int[][][] directions = {
            {}, // 0번 카메라
            {{0}, {1}, {2}, {3}}, // 1번
            {{0, 2}, {1, 3}}, // 2번
            {{3, 0}, {0, 1}, {1, 2}, {2, 3}}, // 3번
            {{2, 3, 0}, {3, 0, 1}, {0, 1, 2}, {1, 2, 3}}, // 4번
            {{0, 1, 2, 3}}, // 5번
    };
    static int minBlindSpot = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 5개의 CCTV
        // 1번은 한 쪽 방향, 2번은 반대 방향
        // 3번은 직각 방향, 4번은 세 방향, 5번은 네 방향
        // 벽이 없는 한 격자 끝까지 감시 가능, CCTV는 통과 가능
        // 카메라를 적절히 배치해 사각 지대를 최소화한다.
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 카메라의 모든 방향에서의 최소 사작 지대를 구해야 한다.
        // 백트래킹으로 모든 카메라의 모든 방향에서의 사각 지대를 계산하고,
        // 모든 카메라의 사각 지대를 계산했으면, 종료 후 사각 지대 수를 갱신한다.
        // 계속 최솟값을 갱신하며 최소 사각 지대수를 구한다.
        cameras = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (1 <= map[i][j] && map[i][j] <= 5) {
                    cameras.add(new int[]{i, j});
                }
            }
        }

        findAllPath(0, map);
        System.out.println(minBlindSpot);
    }

    static void findAllPath(int depth, int[][] map) {
        // 모든 카메라의 위치를 조정했으면 최소 사각 지대를 갱신한다.
        if (depth == cameras.size()) {
            int currentBlind = countBlindSpots(map);
            minBlindSpot = Math.min(minBlindSpot, currentBlind);
            return;
        }

        int x = cameras.get(depth)[0];
        int y = cameras.get(depth)[1];
        int cameraType = map[x][y];
        
        // 모든 카메라에서의 모든 방향을 시도해본다.
        for (int[] dirs : directions[cameraType]) {
            // 현재 카메라의 모든 방향에 대해 맵 복사본을 생성
            int[][] currentMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    currentMap[i][j] = map[i][j];
                }
            }
            // 현재 카메라의 모든 방향을 감시한다.
            for (int dir : dirs) {
                watch(currentMap, x, y, dir);
            }
            findAllPath(depth + 1, currentMap);
        }
    }

    // 현재 맵, 현재 위치에서 dir 방향으로 감시 영역을 표시한다.
    static void watch(int[][] currentMap, int x, int y, int dir) {
        // 전진할 수 있는 만큼 같은 방향으로 계속 전진
        while (true) {
            x += dx[dir];
            y += dy[dir];

            if (!inRange(x, y) || currentMap[x][y] == 6) break;
            if (currentMap[x][y] == 0) currentMap[x][y] = 7; // 감시된 영역으로 표시
        }
    }

    static int countBlindSpots(int[][] map) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
