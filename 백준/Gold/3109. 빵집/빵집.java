import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int r, c;
    static char[][] grid;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        grid = new char[r][c];

        for (int i = 0; i < r; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        int totalPipes = 0;
        for (int i = 0; i < r; i++) {
            if (dfs(i, 0)) {
                totalPipes++;
            }
        }

        System.out.println(totalPipes);
    }

    public static boolean dfs(int row, int col) {
        if (col == c-1) {
            return true;
        }

        for (int dx : new int[]{-1, 0, 1}) {
            int nr = row + dx;
            int nc = col + 1;

            if (nr >= 0 && nr < r && grid[nr][nc] == '.') {
                grid[nr][nc] = 'x';
                if (dfs(nr, nc)) return true;
            }
        }

        return false;
    }
}