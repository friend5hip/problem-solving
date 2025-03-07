import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, m, count;
    static char[][] battlefield;
    static int[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 가로
        m = Integer.parseInt(st.nextToken()); // 세로

        battlefield = new char[m][n];
        for (int i = 0; i < m; i++) {
            String status = br.readLine();
            for (int j = 0; j < n; j++) {
                battlefield[i][j] = status.charAt(j);
            }
        }

        visited = new int[m][n];
        int ourManPower = 0;
        int enemiesPower = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0) {
                    count = 1;
                    dfs(i, j, battlefield[i][j]);
                    if (battlefield[i][j] == 'W') {
                        ourManPower += count * count;
                    } else {
                        enemiesPower += count * count;
                    }
                }
            }
        }

        System.out.println(ourManPower + " " + enemiesPower);
    }

    public static void dfs(int r, int c, char color) {
        visited[r][c] = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if (nr >= 0 && nc >= 0 && nr < m && nc < n && visited[nr][nc] == 0 && battlefield[nr][nc] == color) {
                count++;
                visited[nr][nc] = 1;
                dfs(nr, nc, color);
            }
        }
    }
}