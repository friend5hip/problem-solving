import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[1][1] = true;
        dfs(1, 1);
        System.out.println(flag ? "HaruHaru" : "Hing");

    }

    public static void dfs(int x, int y) {
        if (x == n && y == n) flag = true;

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i] * map[x][y];
            int ny = y + dy[i] * map[x][y];

            if (nx < 1 || nx > n || ny < 1 || ny > n) continue;
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }

}