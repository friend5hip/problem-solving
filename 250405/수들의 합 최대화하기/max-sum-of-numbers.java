import java.util.*;

public class Main {
    static int n, max;
    static int[][] grid;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[n];
        getMax(0, 0);
        System.out.println(max);
    }

    static void getMax(int row, int currentSum) {
        if (row == n) {
            max = Math.max(max, currentSum);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!visited[col]) {
                visited[col] = true;
                getMax(row + 1, currentSum + grid[row][col]);
                visited[col] = false;
            }
        }
    }
}