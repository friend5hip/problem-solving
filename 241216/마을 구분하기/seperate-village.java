import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] visited;
    static ArrayList<Integer> villageSizes;
    static int currentVillageSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        visited = new int[n][n];
        villageSizes = new ArrayList<>();

        // 격자 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 칸을 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 사람이 있고(map[i][j] == 1), 방문하지 않은 곳일 경우에만 탐색
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    currentVillageSize = 0;
                    DFS(i, j, map);
                    villageSizes.add(currentVillageSize);
                }
            }
        }

        // 결과 출력
        Collections.sort(villageSizes);
        System.out.println(villageSizes.size());  // 마을 개수
        for (int size : villageSizes) {
            System.out.println(size);
        }
    }

    static void DFS(int x, int y, int[][] map) {
        // 상하좌우 모두 이동 가능한지 체크
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        visited[x][y] = 1;
        currentVillageSize++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (possible(nx, ny, map)) {
                DFS(nx, ny, map);
            }
        }
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static boolean possible(int x, int y, int[][] map) {
        return inRange(x, y) && visited[x][y] == 0 && map[x][y] == 1;
    }
}