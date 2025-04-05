import java.util.Scanner;

public class Main {
    static int n, min = Integer.MAX_VALUE;
    static int[][] cost;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cost = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cost[i][j] = sc.nextInt();

        visited = new boolean[n];
        visited[0] = true; // 0번 도시에서 시작
        getMin(0, 0, 1, 0);

        System.out.println(min);
    }

    static void getMin(int start, int curr, int depth, int currentSum) {
        if (currentSum >= min) return;

        if (depth == n) {
            if (cost[curr][start] != 0) {
                min = Math.min(min, currentSum + cost[curr][start]);
            }
            return;
        }

        for (int next = 0; next < n; next++) {
            if (!visited[next] && cost[curr][next] != 0) {
                visited[next] = true;
                getMin(start, next, depth + 1, currentSum + cost[curr][next]);
                visited[next] = false;
            }
        }
    }
}
