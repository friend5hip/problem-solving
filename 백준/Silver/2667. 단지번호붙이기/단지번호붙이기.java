import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, count;
    static int[][] visited;
    static int[][] grid;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        visited = new int[n][n];
        List<Integer> answers = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    count = 1;
                    dfs(i, j);
                    answers.add(count);
                }
            }
        }

        Collections.sort(answers);
        System.out.println(answers.size());
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(answers.get(i));
        }
    }

    public static void dfs(int row, int col) {
        visited[row][col] = 1;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n
            && grid[newRow][newCol] == 1 && visited[newRow][newCol] == 0) {
                count++;
                dfs(newRow, newCol);
            }
        }
    }
}
