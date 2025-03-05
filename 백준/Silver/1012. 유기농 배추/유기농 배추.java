import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] visited;
    static int[][] grid;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int count, m, n, k;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로 길이
            n = Integer.parseInt(st.nextToken()); // 세로 길이
            k = Integer.parseInt(st.nextToken()); // 배추의 개수

            // 배추의 위치 입력
            grid = new int[n][m];
            for (int l = 0; l < k; l++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                grid[c][r] = 1;
            }

            visited = new int[n][m];
            count = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (visited[r][c] == 0 && grid[r][c] == 1) {
                        visited[r][c] = 1;
                        dfs(r, c);
                        count++;
                    }
                }
            }
            answers.add(count);
        }

        for (int answer : answers) {
            System.out.println(answer);
        }
    }

    public static void dfs(int currentRow, int currentCol) {
        visited[currentRow][currentCol] = 1;

        for (int i = 0; i < 4; i++) {
            int newRow = currentRow + dx[i];
            int newCol = currentCol + dy[i];
            if (canGo(newRow, newCol) && visited[newRow][newCol] == 0 && grid[newRow][newCol] == 1) {
                dfs(newRow, newCol);
            }
        }
    }

    public static boolean canGo(int row, int col) {
        return row >= 0 && col >= 0 && row < n && col < m;
    }
}
