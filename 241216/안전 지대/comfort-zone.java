import java.io.*;
import java.util.*;

public class Main {
    static int n, m, maxK;
    static int[][] visited = new int[100][100];
    static int currentSafeAreaSize;
    static ArrayList<Integer> safeAreas;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        // N x M 크기의 격자로 구성된 마을 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maxK = 0;
        safeAreas = new ArrayList<>();

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int currentValue = Integer.parseInt(st2.nextToken());
                map[i][j] = currentValue;
                maxK = Math.max(maxK, map[i][j]);
            }
        }

        // 마을 탐색
        for (int k = 1; k <= maxK; k++) {
            visited = new int[n][m];
            currentSafeAreaSize = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // k보다 큰 경우 구역만 진입 가능
                    if (map[i][j] > k && visited[i][j] == 0) {
                        currentSafeAreaSize++;
                        DFS(i, j, map, k);
                    }
                }
            }
            safeAreas.add(currentSafeAreaSize);
        }
        // 안전 영역의 수가 최대가 될때의 k와 그 때의 안전 영역 수
        System.out.print(safeAreas.indexOf(Collections.max(safeAreas)) + 1 + " " + Collections.max(safeAreas));
    }

    static void DFS(int x, int y, int[][] map, int k) {
        visited[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (possible(nx, ny, map, k)) {
                DFS(nx, ny, map, k);
            }
        }
    }

    static boolean possible(int x, int y, int[][] map, int k) {
        return inRange(x, y) && visited[x][y] == 0 && map[x][y] > k;
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}