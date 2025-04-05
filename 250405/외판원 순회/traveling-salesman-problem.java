import java.util.Scanner;

public class Main {
    static int n;
    static int min = Integer.MAX_VALUE;
    static int[][] cost;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[n];
        getMin(0, 0);
        System.out.println(min);
    }

    static void getMin(int row, int currentSum) {
        if (row == n) {
            min = Math.min(min, currentSum);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!visited[col] && cost[row][col] != 0) {
                visited[col] = true;
                getMin(row + 1, currentSum + cost[row][col]);
                visited[col] = false;
            }
        }
    }
}