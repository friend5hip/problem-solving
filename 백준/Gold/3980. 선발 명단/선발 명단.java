import java.util.*;

public class Main {
    static int n, max;
    static int[][] grid;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int t = 0; t < n; t++) {
            grid = new int[11][11];
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 11; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            visited = new boolean[11];
            getMax(0, 0);
            System.out.println(max);
            max = 0;
        }
    }

    static void getMax(int row, int currentSum) {
        if (row == 11) {
            max = Math.max(max, currentSum);
            return;
        }

        for (int col = 0; col < 11; col++) {
            if (!visited[col] && grid[row][col] != 0) {
                visited[col] = true;
                getMax(row + 1, currentSum + grid[row][col]);
                visited[col] = false;
            }
        }
    }
}