import java.io.*;
import java.util.*;

public class Main {
    static int[][] visited = new int[100][100];
    static int n;
    static int m;
    static boolean escaped;

    public static void main(String[] args) throws IOException {
        // n * m의 격자 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        DFS(0, 0, grid);

        if (escaped) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    // 격자를 탐색해서 경로를 탐색
    static void DFS(int x, int y, int[][] grid) {
        int[] dx = new int[]{1, 0};
        int[] dy = new int[]{0, 1};

        visited[x][y] = 1;
        // 탈출 성공
        if (x == n-1 && y == m-1) {
            escaped = true;
        }

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 가능한 움직임이면 재귀 호출
            if (possible(nx, ny, grid)) {
                DFS(nx, ny, grid);
            }
        }
    }

    // 전진 가능한지 체크
    static boolean possible (int x, int y, int[][] grid) {
        if (!inRange(x, y))
            return false;
        // 방문하지 않았고 뱀이 없는지 체크
        if (visited[x][y] == 1 || grid[x][y] == 0)
            return false;
        return true;
    }

    // 격자를 벗어나는지 체크
    static boolean inRange (int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}